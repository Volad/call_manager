
/**
 * 
 */
package com.cm.db.service.user.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cm.db.dao.user.CallerPhraseDao;
import com.cm.db.service.DbServiceAbstract;
import com.cm.db.service.user.CallerPhraseService;
import com.cm.entity.CallerPhrase;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@Service
@Transactional
public class CallerPhraseServiceImpl extends DbServiceAbstract<CallerPhrase, Long>implements CallerPhraseService {

    @Autowired
    private CallerPhraseDao callerPhraseDao;

    @Override
    public JpaRepository<CallerPhrase, Long> getRepository() {
        return callerPhraseDao;
    }

    @Override
    public List<CallerPhrase> findByCallerId(Long id) {
        return callerPhraseDao.findByCallerId(id);
    }

}
