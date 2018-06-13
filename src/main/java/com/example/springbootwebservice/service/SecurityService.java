package com.example.springbootwebservice.service;

import com.example.springbootwebservice.dao.SecurityDao;
import com.example.springbootwebservice.entity.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityService {

    @Autowired
    private SecurityDao dao;

    public List<Security> getAll() {
        return dao.getAll();
    }

    public Security getById(Integer id) {

        return dao.getById(id);
    }

    public synchronized boolean add(Security security) {
        if (dao.isExisting(security.getId(), security.getName())) {
            return false;
        } else {
            dao.add(security);
            return true;
        }

    }

    public void update(Security security) {
        dao.update(security);
    }

    public void delete(Integer id) {
        dao.deleteArticle(id);
    }
}
