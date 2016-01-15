
/**
 * 
 */
package com.cm.db.dao.user.test;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cm.db.dao.customer.CustomerAnswerVariantsDao;
import com.cm.db.dao.customer.CustomerPhraseDao;
import com.cm.db.dao.user.CallerAnswerVariantsDao;
import com.cm.db.dao.user.CallerPhraseDao;
import com.cm.entity.CallerAnswerVariants;
import com.cm.entity.CallerPhrase;
import com.cm.entity.CustomerAnswerVariants;
import com.cm.entity.CustomerPhrase;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@ContextConfiguration(locations = { "classpath:cmDbRepositoryContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class AnswerVariantsDaoTest {
    @Autowired
    private CallerAnswerVariantsDao callerAnswerVariantsDao;
    @Autowired
    private CustomerPhraseDao customerPhraseDao;

    @Autowired
    private CustomerAnswerVariantsDao customerAnswerVariantsDao;
    @Autowired
    private CallerPhraseDao callerPhraseDao;

    @Test
    @Rollback
    public void testFindByCustomerPhraseIdIn() {
        List<CustomerPhrase> allCustomerPhrases = customerPhraseDao.findAll();

        List<Long> customerPhraseIds = allCustomerPhrases.stream().map(c -> c.getId()).collect(Collectors.toList());

        List<CallerAnswerVariants> callerAnswerVariants = callerAnswerVariantsDao
                .findByAnswerVariantIdCustomerPhraseIdIn(customerPhraseIds);

        assertTrue(CollectionUtils.isNotEmpty(callerAnswerVariants));
    }

    @Test
    @Rollback
    public void testFindByCallerPhraseIdIn() {
        List<CallerPhrase> allCallerPhrases = callerPhraseDao.findAll();

        List<Long> callerPhraseIds = allCallerPhrases.stream().map(c -> c.getId()).collect(Collectors.toList());

        List<CustomerAnswerVariants> callerAnswerVariants = customerAnswerVariantsDao
                .findByAnswerVariantIdCallerPhraseIdIn(callerPhraseIds);

        assertTrue(CollectionUtils.isNotEmpty(callerAnswerVariants));
    }
}
