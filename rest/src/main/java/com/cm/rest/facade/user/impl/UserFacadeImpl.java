
/**
 * 
 */
package com.cm.rest.facade.user.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cm.db.service.user.UserService;
import com.cm.entity.User;
import com.cm.rest.facade.user.UserFacade;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@Service
public class UserFacadeImpl implements UserFacade {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserFacadeImpl.class);
    @Autowired
    private UserService userService;

    @Override
    public User getUser(long id, boolean throwException) {
        User user = userService.findById(id);
        if (user == null && throwException) {
            throw new UsernameNotFoundException("User with id " + id + " not found");
        }
        return user;
    }

}
