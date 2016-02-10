
/**
 * 
 */
package com.cm.rest.facade.conversation;

import com.cm.entity.CustomerPhrase;
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

}
