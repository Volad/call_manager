
/**
 * 
 */
package com.cm.db.dao.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cm.db.dao.AnswerVariantsDao;
import com.cm.entity.CallerAnswerVariants;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public interface CallerAnswerVariantsDao extends AnswerVariantsDao<CallerAnswerVariants> {

    @Modifying
    @Query("update caller_answers_variants cav set cav.answerVariantId.callerPhraseId =:callerId where  cav.answerVariantId.customerPhraseId =:customerId")
    void updateByCustomerId(@Param("callerId") Long callerPhraseId, @Param("customerId") Long customerPhraseId);

}
