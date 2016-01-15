
/**
 * 
 */
package com.cm.db.dao.customer.test;

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

import com.cm.db.creator.user.CustomerPhraseCreator;
import com.cm.db.dao.customer.CustomerPhraseDao;
import com.cm.entity.CustomerPhrase;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@ContextConfiguration(locations = { "classpath:cmDbRepositoryContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CustomerPhraseDaoTest {

    @Autowired
    private CustomerPhraseDao customerPhraseDao;

    @Test
    @Rollback
    public void testCreateAndFindAll() {
        CustomerPhrase customerPhrase = CustomerPhraseCreator.create();
        customerPhraseDao.save(customerPhrase);

        List<CustomerPhrase> allCustomers = customerPhraseDao.findAll();

        assertTrue(CollectionUtils.isNotEmpty(allCustomers));
        assertTrue(allCustomers.stream()
                .anyMatch(c -> c.getContent() != null && c.getContent().equals(customerPhrase.getContent())));
    }

}
