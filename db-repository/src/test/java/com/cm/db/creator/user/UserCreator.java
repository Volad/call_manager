
/**
 * 
 */
package com.cm.db.creator.user;

import com.cm.entity.User;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public class UserCreator {

    public static final User create() {
        return UserCreator.create("Test firstName", "TestName", "testlogin", "testlogin", "+375 29 3679953");
    }

    public static final User create(String firstName, String lastName, String login, String password, String phone) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(password);
        user.setPhone(phone);
        return user;
    }
}
