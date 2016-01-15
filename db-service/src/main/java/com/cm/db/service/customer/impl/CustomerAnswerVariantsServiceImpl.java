
/**
 * 
 */
package com.cm.db.service.customer.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.db.dao.AnswerVariantsDao;
import com.cm.db.dao.customer.CustomerAnswerVariantsDao;
import com.cm.db.service.AnswerVariantsServiceAbstract;
import com.cm.db.service.customer.CustomerAnswerVariantsService;
import com.cm.entity.CustomerAnswerVariants;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@Service
@Transactional
public class CustomerAnswerVariantsServiceImpl extends AnswerVariantsServiceAbstract<CustomerAnswerVariants>
        implements CustomerAnswerVariantsService {

    @Autowired
    private CustomerAnswerVariantsDao dao;

    @Override
    protected AnswerVariantsDao<CustomerAnswerVariants> getInheritedRepository() {
        return dao;
    }

}
