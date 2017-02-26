package com.papchenko.dao.impl;

import com.papchenko.dao.PollDao;
import com.papchenko.entity.Poll;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
@Repository
@Transactional
public class PollDaoImpl implements PollDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public int save(Poll poll) {
        Session session = sessionFactory.getCurrentSession();
        Integer id = (Integer)session.save(poll);
        return id;
    }

    @Override
    public List<Poll> all() {
        Session session = sessionFactory.getCurrentSession();
        List<Poll> polls = session.createQuery("from Poll").list();
        return polls;
    }
}
