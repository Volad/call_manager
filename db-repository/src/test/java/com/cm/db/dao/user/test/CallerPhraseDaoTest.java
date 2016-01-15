
/**
 * 
 */
package com.cm.db.dao.user.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cm.db.creator.user.CallerPhraseCreator;
import com.cm.db.dao.user.CallerPhraseDao;
import com.cm.entity.CallerPhrase;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@ContextConfiguration(locations = { "classpath:cmDbRepositoryContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CallerPhraseDaoTest {
    @Autowired
    private CallerPhraseDao callerPhraseDao;

    @Test
    @Rollback
    public void testCreateAndFindAll() {
        CallerPhrase callerPhrase = CallerPhraseCreator.create();
        callerPhraseDao.save(callerPhrase);
        List<CallerPhrase> allCallerPhrase = callerPhraseDao.findAll();

        assertTrue(CollectionUtils.isNotEmpty(allCallerPhrase));
        assertTrue(allCallerPhrase.stream()
                .anyMatch(c -> c.getTitle() != null && c.getTitle().equals(callerPhrase.getTitle())));
    }
}
