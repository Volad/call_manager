
/**
 * 
 */
package com.cm.db.service.call.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cm.db.dao.call.CallDao;
import com.cm.db.service.DbServiceAbstract;
import com.cm.db.service.call.CallService;
import com.cm.entity.Call;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@Service
@Transactional
public class CallServiceImpl extends DbServiceAbstract<Call, Long>implements CallService {

    @Autowired
    private CallDao callDao;

    @Override
    public JpaRepository<Call, Long> getRepository() {
        return callDao;
    }

}
