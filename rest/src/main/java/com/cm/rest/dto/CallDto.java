
/**
 * 
 */
package com.cm.rest.dto;

import java.util.Date;
import java.util.List;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public class CallDto {

    private Long callerId;

    private Long customerId;

    private Date startTime;

    private Date endTime;

    private List<CallerPhraseDto> history;

    /**
     * @return the callerId
     */
    public Long getCallerId() {
        return callerId;
    }

    /**
     * @param callerId the callerId to set
     */
    public void setCallerId(Long callerId) {
        this.callerId = callerId;
    }

    /**
     * @return the customerId
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the history
     */
    public List<CallerPhraseDto> getHistory() {
        return history;
    }

    /**
     * @param history the history to set
     */
    public void setHistory(List<CallerPhraseDto> history) {
        this.history = history;
    }

}
