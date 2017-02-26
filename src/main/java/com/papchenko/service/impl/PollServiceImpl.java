package com.papchenko.service.impl;

import com.papchenko.dao.OptionsDao;
import com.papchenko.dao.PollDao;
import com.papchenko.dto.PollDto;
import com.papchenko.entity.Option;
import com.papchenko.entity.Poll;
import com.papchenko.service.PollService;
import com.papchenko.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(readOnly = true)
    public List<PollDto> all() {
        return pollDao.all().stream().map(Transformer::fromPollEntity).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void save(PollDto poll) {
        Poll pollEntity = Transformer.fromPollDto(poll, true);
        pollDao.save(pollEntity);

        poll.getOptions().forEach(opt -> {Option option = Transformer.fromOptionDto(opt);
            option.setPoll(pollEntity);
            optionsDao.save(option);
        });
    }

    @Override
    @Transactional
    public synchronized void saveAnswer(int id) {
        Option option = optionsDao.getById(id);
        option.setCount(option.getCount() + 1);
        optionsDao.save(option);
    }
}
