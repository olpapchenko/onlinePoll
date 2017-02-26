package com.papchenko.service;

import com.papchenko.dto.PollDto;

import java.util.List;

/**
 * Created by user on 26.02.2017.
 */
public interface PollService {
    List<PollDto> all();
    void save(PollDto poll);
    void saveAnswer(int id);
}
