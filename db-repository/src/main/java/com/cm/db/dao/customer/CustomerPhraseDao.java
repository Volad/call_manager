
/**
 * 
 */
package com.cm.db.dao.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cm.entity.CustomerPhrase;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public interface CustomerPhraseDao extends JpaRepository<CustomerPhrase, Long> {

}
