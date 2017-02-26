package com.papchenko.dao;

import com.papchenko.entity.Poll;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public interface PollDao {
    List<Poll> all();
    int save(Poll poll);
}
