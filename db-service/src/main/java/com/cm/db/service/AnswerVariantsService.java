
/**
 * 
 */
package com.cm.db.service;

import java.util.List;

import com.cm.entity.AnswerVariantId;
import com.cm.entity.AnswerVariants;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public interface AnswerVariantsService<T extends AnswerVariants> extends DbService<T, AnswerVariantId> {
    List<T> findByAnswerVariantIdCustomerPhraseIdIn(List<Long> customerPhraseId);

    List<T> findByAnswerVariantIdCallerPhraseIdIn(List<Long> callerPhraseId);
}
