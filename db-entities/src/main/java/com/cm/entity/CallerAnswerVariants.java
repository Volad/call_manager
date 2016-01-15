
/**
 * 
 */
package com.cm.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@Entity(name = "caller_answers_variants")
public class CallerAnswerVariants implements AnswerVariants {

    @EmbeddedId
    private AnswerVariantId answerVariantId;

    /**
     * @return the answerVariantId
     */
    public AnswerVariantId getAnswerVariantId() {
        return answerVariantId;
    }

    /**
     * @param answerVariantId the answerVariantId to set
     */
    public void setAnswerVariantId(AnswerVariantId answerVariantId) {
        this.answerVariantId = answerVariantId;
    }

}
