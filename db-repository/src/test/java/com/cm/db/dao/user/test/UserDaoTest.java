
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

import com.cm.db.creator.user.UserCreator;
import com.cm.db.dao.user.UserDao;
import com.cm.entity.User;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@ContextConfiguration(locations = { "classpath:cmDbRepositoryContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    @Rollback
    public void testCreateAndFindAll() {
        User user = UserCreator.create();
        userDao.save(user);

        List<User> allCustomers = userDao.findAll();

        assertTrue(CollectionUtils.isNotEmpty(allCustomers));
        assertTrue(allCustomers.stream().anyMatch(u -> u.getPhone() != null && u.getPhone().equals(user.getPhone())));
    }
}
