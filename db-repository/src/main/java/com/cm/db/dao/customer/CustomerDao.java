
/**
 * 
 */
package com.cm.db.dao.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cm.entity.Customer;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */

public interface CustomerDao extends JpaRepository<Customer, Long> {

}
