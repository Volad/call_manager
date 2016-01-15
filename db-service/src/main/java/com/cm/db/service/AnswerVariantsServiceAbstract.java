
/**
 * 
 */
package com.cm.db.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cm.db.dao.AnswerVariantsDao;
import com.cm.entity.AnswerVariantId;
import com.cm.entity.AnswerVariants;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
public abstract class AnswerVariantsServiceAbstract<T extends AnswerVariants>
        extends DbServiceAbstract<T, AnswerVariantId>implements AnswerVariantsService<T> {

    protected abstract AnswerVariantsDao<T> getInheritedRepository();

    /*
     * (non-Javadoc)
     * @see com.cm.db.service.DbService#getRepository()
     */
    @Override
    public JpaRepository<T, AnswerVariantId> getRepository() {
        return getInheritedRepository();
    }

    @Override
    public List<T> findByAnswerVariantIdCustomerPhraseIdIn(List<Long> customerPhraseId) {
        return getInheritedRepository().findByAnswerVariantIdCustomerPhraseIdIn(customerPhraseId);
    }

    @Override
    public List<T> findByAnswerVariantIdCallerPhraseIdIn(List<Long> callerPhraseId) {
        return getInheritedRepository().findByAnswerVariantIdCallerPhraseIdIn(callerPhraseId);
    }

}
