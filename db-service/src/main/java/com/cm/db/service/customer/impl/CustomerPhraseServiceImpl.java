
/**
 * 
 */
package com.cm.db.service.customer.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cm.db.dao.customer.CustomerPhraseDao;
import com.cm.db.service.DbServiceAbstract;
import com.cm.db.service.customer.CustomerPhraseService;
import com.cm.entity.CustomerPhrase;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@Service
@Transactional
public class CustomerPhraseServiceImpl extends DbServiceAbstract<CustomerPhrase, Long>implements CustomerPhraseService {

    @Autowired
    private CustomerPhraseDao customerPhraseDao;

    @Override
    public JpaRepository<CustomerPhrase, Long> getRepository() {
        return customerPhraseDao;
    }

}
