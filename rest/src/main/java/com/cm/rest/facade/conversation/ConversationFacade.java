
/**
 * 
 */
package com.cm.rest.facade.conversation;

import com.cm.entity.CallerPhrase;
import com.cm.entity.CustomerPhrase;
import com.cm.rest.dto.CallDto;
import com.cm.rest.dto.ConversationDto;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public interface ConversationFacade {

    ConversationDto loadUserConversationStructure(long userId);

    void updateCustomerPhrase(CustomerPhrase customerPhrase);

    CustomerPhrase createCustomerPhrase(Long callerPhraseId, CustomerPhrase customerPhrase);

    void deleteCustomerPhrase(Long callerPhraseId, Long customerPhraseId);

    void saveCall(CallDto callDto);

    CallerPhrase createCallerPhrase(CallerPhrase callerPhrase);

    void updateCustomerAnsweVariants(Long customerPhraseId, Long callerPhraseId);

}
