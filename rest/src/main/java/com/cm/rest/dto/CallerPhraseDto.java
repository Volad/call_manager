
/**
 * 
 */
package com.cm.rest.dto;

import java.util.List;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public class CallerPhraseDto {
    private Long id;

    private String title;

    private Long callerId;

    private int position;

    private boolean initial;

    private List<CustomerPhraseDto> customerPhrases;

    private int historyIndex;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

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
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @return the initial
     */
    public boolean isInitial() {
        return initial;
    }

    /**
     * @param initial the initial to set
     */
    public void setInitial(boolean initial) {
        this.initial = initial;
    }

    /**
     * @return the customerPhrases
     */
    public List<CustomerPhraseDto> getCustomerPhrases() {
        return customerPhrases;
    }

    /**
     * @param customerPhrases the customerPhrases to set
     */
    public void setCustomerPhrases(List<CustomerPhraseDto> customerPhrases) {
        this.customerPhrases = customerPhrases;
    }
}
