package com.papchenko.util;

import com.papchenko.dto.OptionDto;
import com.papchenko.dto.PollDto;
import com.papchenko.entity.Option;
import com.papchenko.entity.Poll;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by user on 26.02.2017.
 */
public class Transformer {
    public static PollDto fromPollEntity(Poll entity) {
        PollDto pollDto = new PollDto();

        pollDto.setId(entity.getId());
        pollDto.setName(entity.getName());
        pollDto.setText(entity.getText());

        Integer allCount = entity.getOptions().stream().map(e -> e.getCount()).reduce(0, (a, b) -> a + b);

        Set<OptionDto> options = entity.getOptions().stream().map(e -> {
            OptionDto optionDto = new OptionDto();
            optionDto.setText(e.getText());
            optionDto.setId(e.getId());
            optionDto.setPercent(100 * e.getCount() / allCount);
            return optionDto;
        }).collect(Collectors.toSet());

        pollDto.setOptions(options);

        return pollDto;
    }

    public static Poll fromPollDto(PollDto pollDto) {
        Poll entity = new Poll();

        entity.setId(pollDto.getId());
        entity.setText(pollDto.getText());
        entity.setName(pollDto.getName());

        Set<Option> options = pollDto.getOptions().stream().map(opt -> new Option() {
            {
                setCount(opt.getCount());
                setId(opt.getId());
                setText(opt.getText());
            }
        }).collect(Collectors.toSet());

        entity.setOption(options);

        return entity;
    }
}
