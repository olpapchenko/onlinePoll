package com.papchenko.dao.impl;

import com.papchenko.dao.OptionsDao;
import com.papchenko.entity.Option;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by user on 26.02.2017.
 */
@Repository
@Transactional
public class OptionsDaoImpl implements OptionsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Option option) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(option);
    }

    @Override
    public Option getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Option option = (Option) session.get(Option.class, id);
        return option;
    }
}
