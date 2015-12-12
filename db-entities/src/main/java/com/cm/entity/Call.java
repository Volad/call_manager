package com.cm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@Entity
public class Call {

    @Id
    @Column
    private Long id;

    @Column
    private Date startTime;

    @Column
    private Date endTime;

    @Column
    private Long callerId;

    @Column
    private Long customerId;

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
}
