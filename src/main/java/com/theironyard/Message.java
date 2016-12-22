package com.theironyard;

import javax.persistence.*;

/**
 * Created by boun on 12/20/16.
 */

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false)
    String text;

    public Message() {
    }

    public Message(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public Message(String text) {
        this.text = text;
    }

    public void message() {
    }
}
