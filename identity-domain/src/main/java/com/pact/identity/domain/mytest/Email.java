package com.pact.identity.domain.mytest;

import javax.persistence.*;

/**
 * Created by apple on 7/14/14.
 */
@Entity(name="test_emails")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String subject;

    @OneToOne
    Message message;

    public Email()
    {

    }

    public Email(String subject){
        setSubject(subject);
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
