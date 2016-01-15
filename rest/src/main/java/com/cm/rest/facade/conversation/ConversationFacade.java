
/**
 * 
 */
package com.cm.rest.facade.conversation;

import com.cm.rest.dto.ConversationDto;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public interface ConversationFacade {

    ConversationDto loadUserConversationStructure(long userId);

}
