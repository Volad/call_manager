
/**
 * 
 */
package com.cm.db.service.user;

import java.util.List;

import com.cm.db.service.DbService;
import com.cm.entity.CallerPhrase;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public interface CallerPhraseService extends DbService<CallerPhrase, Long> {

    List<CallerPhrase> findByCallerId(Long id);
}
