package com.papchenko.dto;

import java.util.Set;

/**
 * Created by user on 26.02.2017.
 */
public class PollDto {
    private int id;
    private String name;
    private String text;
    private Set<OptionDto> options;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public Set<OptionDto> getOptions() {
        return options;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOptions(Set<OptionDto> options) {
        this.options = options;
    }
}
