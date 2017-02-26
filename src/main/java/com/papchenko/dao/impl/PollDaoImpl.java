package com.papchenko.dao.impl;

import com.papchenko.dao.PollDao;
import com.papchenko.entity.Poll;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
@Repository
public class PollDaoImpl implements PollDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Poll poll) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(poll);
        tx.commit();
        session.close();
    }

    @Override
    public List<Poll> all() {
        Session session = sessionFactory.openSession();
        List<Poll> polls = session.createQuery("from Poll").list();
        session.close();
        return polls;
    }
}
