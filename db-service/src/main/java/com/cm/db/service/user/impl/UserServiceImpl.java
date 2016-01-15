
/**
 * 
 */
package com.cm.db.service.user.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cm.db.dao.user.UserDao;
import com.cm.db.service.DbServiceAbstract;
import com.cm.db.service.user.UserService;
import com.cm.entity.User;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@Service
@Transactional
public class UserServiceImpl extends DbServiceAbstract<User, Long>implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public JpaRepository<User, Long> getRepository() {
        return dao;
    }
}
