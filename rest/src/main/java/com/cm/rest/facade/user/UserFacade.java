
/**
 * 
 */
package com.cm.rest.facade.user;

import com.cm.entity.User;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public interface UserFacade {
    User getUser(long id, boolean throwException);
}
