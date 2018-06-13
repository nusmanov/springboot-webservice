package com.example.springbootwebservice.dao;

import com.example.springbootwebservice.entity.Security;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class SecurityDao {

    @PersistenceContext
    private EntityManager entityManager;

    // read
    public Security getById(Integer id) {
        // return entityManager.find(Security.class, id);

        return  new Security(Integer.valueOf(id), "Name" + id);
    }

    // find all
    public List<Security> getAll() {
        String hql = "FROM Security as sec ORDER BY sec.id";
        return (List<Security>) entityManager.createQuery(hql).getResultList();
    }

    // create
    public void add(Security security) {
        entityManager.persist(security);
    }

    // update
    public void update(Security security) {
        Security sec = getById(security.getId());
        sec.setName(security.getName());
        entityManager.flush();
    }

    // delete
    public void deleteArticle(Integer id) {
        entityManager.remove(getById(id));
    }

    public boolean isExisting(Integer id, String name) {
        String hql = "FROM Security as sec WHERE sec.id = ? and sec.name = ?";
        int count = entityManager.createQuery(hql).setParameter(1, id)
                .setParameter(2, name).getResultList().size();
        return count > 0 ? true : false;
    }
}
