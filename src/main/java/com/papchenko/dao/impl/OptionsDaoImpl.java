package com.papchenko.dao.impl;

import com.papchenko.dao.OptionsDao;
import com.papchenko.entity.Option;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 26.02.2017.
 */
@Repository
public class OptionsDaoImpl implements OptionsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Option option) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(option);
        tx.commit();
        session.close();
    }

    @Override
    public Option getById(int id) {
        Session session = sessionFactory.openSession();
        Option option = (Option) session.get(Option.class, id);
        return option;
    }
}
