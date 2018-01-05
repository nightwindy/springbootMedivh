package com.windy.medivh.dao.repository;


import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class AbstractDao<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BatchDAO<T> {

    protected Class<T> domainClass;
    protected EntityManager em;

    public AbstractDao(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.domainClass = domainClass;
        this.em = entityManager;
    }

    @Override
    @Transactional
    public void batchInsert(List list) {
        for (int i = 0; i < list.size(); i++) {
            em.persist(list.get(i));
            if (i % 30 == 0) {
                em.flush();
                em.clear();
            }
        }
    }

    @Override
    @Transactional
    public void batchUpdate(List list) {
        for (int i = 0; i < list.size(); i++) {
            em.merge(list.get(i));
            if (i % 30 == 0) {
                em.flush();
                em.clear();
            }
        }
    }
}
   