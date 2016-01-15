
/**
 * 
 */
package com.cm.db.dao.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cm.entity.CallerPhrase;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public interface CallerPhraseDao extends JpaRepository<CallerPhrase, Long> {

    List<CallerPhrase> findByCallerId(Long id);

}
