package com.papchenko.dao;

import com.papchenko.entity.Option;

/**
 * Created by user on 26.02.2017.
 */
public interface OptionsDao {
    void save(Option option);
    Option getById(int id);
}
