
/**
 * 
 */
package com.cm.rest.facade.conversation.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.db.service.call.CallService;
import com.cm.db.service.customer.CustomerAnswerVariantsService;
import com.cm.db.service.customer.CustomerPhraseService;
import com.cm.db.service.user.CallerAnswerVariantsService;
import com.cm.db.service.user.CallerPhraseService;
import com.cm.entity.AnswerVariantId;
import com.cm.entity.Call;
import com.cm.entity.CallerAnswerVariants;
import com.cm.entity.CallerPhrase;
import com.cm.entity.CustomerAnswerVariants;
import com.cm.entity.CustomerPhrase;
import com.cm.entity.User;
import com.cm.rest.dto.CallDto;
import com.cm.rest.dto.ConversationDto;
import com.cm.rest.facade.conversation.ConversationFacade;
import com.cm.rest.facade.user.UserFacade;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@Service
@Transactional
public class ConversationFacadeImpl implements ConversationFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConversationFacadeImpl.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private CallerPhraseService callerPhraseService;

    @Autowired
    private CustomerPhraseService customerPhraseService;

    @Autowired
    private CustomerAnswerVariantsService customerAnswerVariantsService;

    @Autowired
    private CallerAnswerVariantsService callerAnswerVariantsService;

    @Autowired
    private CallService callService;

    @Override
    public ConversationDto loadUserConversationStructure(long userId) {
        User user = userFacade.getUser(userId, true);
        LOGGER.info("Start loading user {} conversation data");
        ConversationDto result = new ConversationDto();
        List<CallerPhrase> callerPhrases = callerPhraseService.findByCallerId(user.getId());

        List<Long> callerPhraseIds = callerPhrases.stream().map(c -> c.getId()).collect(Collectors.toList());
        List<CustomerAnswerVariants> customerAnswerVariants = customerAnswerVariantsService
                .findByAnswerVariantIdCallerPhraseIdIn(callerPhraseIds);
        List<Long> customerPhraseIds = customerAnswerVariants.stream()
                .map(c -> c.getAnswerVariantId().getCustomerPhraseId()).collect(Collectors.toList());

        List<CallerAnswerVariants> callerAnswerVariants = callerAnswerVariantsService
                .findByAnswerVariantIdCustomerPhraseIdIn(customerPhraseIds);

        result.setCustomerPhrase(customerPhraseService.findByIds(customerPhraseIds));
        result.setCallerPhrases(callerPhrases);
        result.setCustomerAnswerVariants(
                customerAnswerVariants.stream().map(c -> c.getAnswerVariantId()).collect(Collectors.toList()));
        result.setCallerAnswerVariants(
                callerAnswerVariants.stream().map(c -> c.getAnswerVariantId()).collect(Collectors.toList()));

        LOGGER.info("User {} conversation data loaded");
        return result;
    }

    @Override
    public void updateCustomerPhrase(CustomerPhrase customerPhrase) {
        LOGGER.info("Updating customerPhrase {}", customerPhrase);
        customerPhraseService.save(customerPhrase);
    }

    @Override
    public CustomerPhrase createCustomerPhrase(Long callerPhraseId, CustomerPhrase customerPhrase) {
        LOGGER.info("create Customer Phrase callerPhraseId {} customerPhrase {}", callerPhraseId, customerPhrase);
        CustomerPhrase customerP = customerPhraseService.save(customerPhrase);
        CustomerAnswerVariants cav = new CustomerAnswerVariants();

        AnswerVariantId varId = new AnswerVariantId();
        varId.setCallerPhraseId(callerPhraseId);
        varId.setCustomerPhraseId(customerP.getId());
        cav.setAnswerVariantId(varId);

        customerAnswerVariantsService.save(cav);
        return customerP;
    }

    @Override
    public void deleteCustomerPhrase(Long callerPhraseId, Long customerPhraseId) {
        LOGGER.info("delete Customer Phrase callerPhraseId {} customerPhrase {}", callerPhraseId, customerPhraseId);
        AnswerVariantId varId = new AnswerVariantId();
        varId.setCallerPhraseId(callerPhraseId);
        varId.setCustomerPhraseId(customerPhraseId);
        customerAnswerVariantsService.delete(varId);
    }

    @Override
    public void saveCall(CallDto callDto) {
        Call call = covertToCall(callDto);
        callService.save(call);
    }

    /**
     * @param callDto
     * @return
     */
    private Call covertToCall(CallDto callDto) {
        Call call = new Call();
        call.setCallerId(callDto.getCallerId());
        call.setCustomerId(callDto.getCustomerId());
        call.setStartTime(callDto.getStartTime());
        call.setEndTime(callDto.getEndTime());
        try {
            call.setHistory(MAPPER.writeValueAsString(callDto.getHistory()));
        } catch (JsonProcessingException e) {
            LOGGER.error("Error on parse to dto", callDto);
        }
        return call;
    }

    @Override
    public CallerPhrase createCallerPhrase(CallerPhrase callerPhrase) {
        return callerPhraseService.save(callerPhrase);
    }

    /*
     * (non-Javadoc)
     * @see com.cm.rest.facade.conversation.ConversationFacade#updateCustomerAnsweVariants(java.lang.Long,
     * java.lang.Long)
     */
    @Override
    public void updateCustomerAnsweVariants(Long customerPhraseId, Long callerPhraseId) {
        CallerAnswerVariants cav = callerAnswerVariantsService
                .findByAnswerVariantIdCustomerPhraseIdIn(Arrays.asList(customerPhraseId)).stream().findAny()
                .orElse(null);

        if (cav != null) {
            callerAnswerVariantsService.updateByCustomerPhraseId(callerPhraseId, customerPhraseId);
        } else {
            cav = new CallerAnswerVariants();
            AnswerVariantId varId = new AnswerVariantId();
            varId.setCallerPhraseId(callerPhraseId);
            varId.setCustomerPhraseId(customerPhraseId);
            cav.setAnswerVariantId(varId);
            callerAnswerVariantsService.save(cav);
        }

    }

}
