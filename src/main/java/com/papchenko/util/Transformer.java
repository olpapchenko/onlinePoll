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
            optionDto.setPercent(allCount == 0 ? 0: 100 * e.getCount() / allCount);
            return optionDto;
        }).collect(Collectors.toSet());

        pollDto.setOptions(options);

        return pollDto;
    }

    public static Option fromOptionDto(OptionDto option) {
        Option entity = new Option();
        entity.setCount(option.getCount());
        entity.setText(option.getText());

        return entity;
    }

    public static Poll fromPollDto(PollDto pollDto, boolean omitId) {
        Poll entity = new Poll();

        if (!omitId) {
            entity.setId(pollDto.getId());
        }

        entity.setText(pollDto.getText());
        entity.setName(pollDto.getName());



        return entity;
    }
}
