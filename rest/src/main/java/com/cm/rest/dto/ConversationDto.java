
/**
 * 
 */
package com.cm.rest.dto;

import java.util.List;

import com.cm.entity.AnswerVariantId;
import com.cm.entity.CallerPhrase;
import com.cm.entity.CustomerPhrase;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public class ConversationDto {
    private List<CallerPhrase> callerPhrases;

    private List<CustomerPhrase> customerPhrase;

    private List<AnswerVariantId> callerAnswersVariants;

    private List<AnswerVariantId> customerAnswerVariants;

    /**
     * @return the callerPhrases
     */
    public List<CallerPhrase> getCallerPhrases() {
        return callerPhrases;
    }

    /**
     * @param callerPhrases the callerPhrases to set
     */
    public void setCallerPhrases(List<CallerPhrase> callerPhrases) {
        this.callerPhrases = callerPhrases;
    }

    /**
     * @return the customerPhrase
     */
    public List<CustomerPhrase> getCustomerPhrase() {
        return customerPhrase;
    }

    /**
     * @param customerPhrase the customerPhrase to set
     */
    public void setCustomerPhrase(List<CustomerPhrase> customerPhrase) {
        this.customerPhrase = customerPhrase;
    }

    /**
     * @return the callerAnswersVariants
     */
    public List<AnswerVariantId> getCallerAnswersVariants() {
        return callerAnswersVariants;
    }

    /**
     * @param callerAnswersVariants the callerAnswersVariants to set
     */
    public void setCallerAnswersVariants(List<AnswerVariantId> callerAnswersVariants) {
        this.callerAnswersVariants = callerAnswersVariants;
    }

    /**
     * @return the customerAnswerVariants
     */
    public List<AnswerVariantId> getCustomerAnswerVariants() {
        return customerAnswerVariants;
    }

    /**
     * @param customerAnswerVariants the customerAnswerVariants to set
     */
    public void setCustomerAnswerVariants(List<AnswerVariantId> customerAnswerVariants) {
        this.customerAnswerVariants = customerAnswerVariants;
    }

}
