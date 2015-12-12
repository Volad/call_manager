
package com.cm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@Entity
public class CallerPhrase {
    @Id
    @Column
    private Long id;

    @Column
    private String title;

    @Column
    private Long callerId;

    @Column
    private int position;

    @Column(name = "is_initial")
    private boolean initial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "caller_answer", joinColumns = {
            @JoinColumn(name = "caller_phrase_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "customer_phrase_id", referencedColumnName = "id") })
    private List<CustomerPhrase> customerPhrases;

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

}
