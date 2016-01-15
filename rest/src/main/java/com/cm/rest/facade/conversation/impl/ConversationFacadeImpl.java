
/**
 * 
 */
package com.cm.rest.facade.conversation.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.db.service.customer.CustomerAnswerVariantsService;
import com.cm.db.service.customer.CustomerPhraseService;
import com.cm.db.service.user.CallerAnswerVariantsService;
import com.cm.db.service.user.CallerPhraseService;
import com.cm.entity.CallerAnswerVariants;
import com.cm.entity.CallerPhrase;
import com.cm.entity.CustomerAnswerVariants;
import com.cm.entity.User;
import com.cm.rest.dto.ConversationDto;
import com.cm.rest.facade.conversation.ConversationFacade;
import com.cm.rest.facade.user.UserFacade;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@Service
@Transactional
public class ConversationFacadeImpl implements ConversationFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConversationFacadeImpl.class);

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
        result.setCallerAnswersVariants(
                callerAnswerVariants.stream().map(c -> c.getAnswerVariantId()).collect(Collectors.toList()));

        LOGGER.info("User {} conversation data loaded");
        return result;
    }

}