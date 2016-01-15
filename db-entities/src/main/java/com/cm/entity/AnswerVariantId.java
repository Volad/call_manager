
/**
 * 
 */
package com.cm.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@Embeddable
public class AnswerVariantId implements Serializable {

    private static final long serialVersionUID = -3820449811246159760L;

    @Column(name = "customer_phrase_id")
    private Long customerPhraseId;

    @Column(name = "caller_phrase_id")
    private Long callerPhraseId;

    /**
     * @return the customerPhraseId
     */
    public Long getCustomerPhraseId() {
        return customerPhraseId;
    }

    /**
     * @param customerPhraseId the customerPhraseId to set
     */
    public void setCustomerPhraseId(Long customerPhraseId) {
        this.customerPhraseId = customerPhraseId;
    }

    /**
     * @return the callerPhraseId
     */
    public Long getCallerPhraseId() {
        return callerPhraseId;
    }

    /**
     * @param callerPhraseId the callerPhraseId to set
     */
    public void setCallerPhraseId(Long callerPhraseId) {
        this.callerPhraseId = callerPhraseId;
    }

}
