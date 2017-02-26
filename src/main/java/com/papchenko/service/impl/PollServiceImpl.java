package com.papchenko.service.impl;

import com.papchenko.dao.OptionsDao;
import com.papchenko.dao.PollDao;
import com.papchenko.dto.PollDto;
import com.papchenko.entity.Option;
import com.papchenko.service.PollService;
import com.papchenko.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by user on 26.02.2017.
 */
@Service
public class PollServiceImpl implements PollService {
    @Autowired
    private PollDao pollDao;

    @Autowired
    private OptionsDao optionsDao;

    @Override
    public List<PollDto> all() {
        return pollDao.all().stream().map(Transformer::fromPollEntity).collect(Collectors.toList());
    }

    @Override
    public void save(PollDto poll) {
        pollDao.save(Transformer.fromPollDto(poll));
    }

    @Override
    public synchronized void saveAnswer(int id) {
        Option option = optionsDao.getById(id);
        option.setCount(option.getCount() + 1);
        optionsDao.save(option);
    }
}
