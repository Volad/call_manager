
/**
 * 
 */
package com.cm.db.service.user.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cm.db.dao.AnswerVariantsDao;
import com.cm.db.dao.user.CallerAnswerVariantsDao;
import com.cm.db.service.AnswerVariantsServiceAbstract;
import com.cm.db.service.user.CallerAnswerVariantsService;
import com.cm.entity.CallerAnswerVariants;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@Service
@Transactional
public class CallerAnswerVariantsServiceImpl extends AnswerVariantsServiceAbstract<CallerAnswerVariants>
        implements CallerAnswerVariantsService {

    @Autowired
    private CallerAnswerVariantsDao dao;

    @Override
    protected AnswerVariantsDao<CallerAnswerVariants> getInheritedRepository() {
        return dao;
    }

}
