
/**
 * 
 */
package com.cm.db.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cm.entity.User;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public interface UserDao extends JpaRepository<User, Long> {

}
