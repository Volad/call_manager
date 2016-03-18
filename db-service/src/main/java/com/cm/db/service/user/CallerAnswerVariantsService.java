
/**
 * 
 */
package com.cm.db.service.user;

import com.cm.db.service.AnswerVariantsService;
import com.cm.entity.CallerAnswerVariants;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public interface CallerAnswerVariantsService extends AnswerVariantsService<CallerAnswerVariants> {

    void updateByCustomerPhraseId(Long callerPhraseId, Long customerPhraseId);

}
