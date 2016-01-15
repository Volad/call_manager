
/**
 * 
 */
package com.cm.db.service.customer.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cm.db.dao.customer.CustomerDao;
import com.cm.db.service.DbServiceAbstract;
import com.cm.db.service.customer.CustomerService;
import com.cm.entity.Customer;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@Service
@Transactional
public class CustomerServiceImpl extends DbServiceAbstract<Customer, Long>implements CustomerService {

    @Autowired
    private CustomerDao dao;

    @Override
    public JpaRepository<Customer, Long> getRepository() {
        return dao;
    }
}
