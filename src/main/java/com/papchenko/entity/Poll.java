package com.papchenko.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * Created by user on 26.02.2017.
 */

@Entity
@Table(name = "POLLS")
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "polls_sequence")
    @SequenceGenerator(
            name="polls_sequence",
            sequenceName="polls_sequence")
    private int id;

    private String text;

    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "poll", cascade = {javax.persistence.CascadeType.PERSIST})
    private Set<Option> options;

    public Set<Option> getOptions() {
        return options;
    }

    public void setOption(Set<Option> option) {
        this.options = option;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Polls{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Poll polls = (Poll) o;
        return Objects.equals(id, polls.id) &&
                Objects.equals(text, polls.text) &&
                Objects.equals(name, polls.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, name);
    }
}
