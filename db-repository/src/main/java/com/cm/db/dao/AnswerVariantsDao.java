
/**
 * 
 */
package com.cm.db.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.cm.entity.AnswerVariantId;
import com.cm.entity.AnswerVariants;

/**
 * @author VladislavKondratenko (k.volad@gmail.com)
 *
 */
@NoRepositoryBean
public interface AnswerVariantsDao<T extends AnswerVariants> extends JpaRepository<T, AnswerVariantId> {
    List<T> findByAnswerVariantIdCustomerPhraseIdIn(List<Long> customerPhraseId);

    List<T> findByAnswerVariantIdCallerPhraseIdIn(List<Long> callerPhraseId);

}
