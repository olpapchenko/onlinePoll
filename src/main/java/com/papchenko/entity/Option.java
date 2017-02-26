package com.papchenko.entity;

import javax.persistence.*;

/**
 * Created by user on 26.02.2017.
 */
@Entity
@Table(name = "OPTIONS")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "polls_sequence")
    @SequenceGenerator(
            name="polls_sequence",
            sequenceName="polls_sequence")
    private int id;

    private String text;

    private int count;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {javax.persistence.CascadeType.PERSIST})
    @JoinColumn(name = "POLL_ID", nullable = false)
    private Poll poll;

    public Poll getPoll() {
        return poll;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getCount() {
        return count;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCount(int count) {
        this.count = count;
    }


}
