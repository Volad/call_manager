
/**
 * 
 */
package com.cm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@Entity
public class CustomerPhrase {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String content;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "caller_phrase", joinColumns = {
            @JoinColumn(name = "customer_phrase_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "caller_phrase_id", referencedColumnName = "id") })
    private CallerPhrase callerPhrase;
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
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the callerPhrase
     */
    public CallerPhrase getCallerPhrase() {
        return callerPhrase;
    }

    /**
     * @param callerPhrase the callerPhrase to set
     */
    public void setCallerPhrase(CallerPhrase callerPhrase) {
        this.callerPhrase = callerPhrase;
    }
}
