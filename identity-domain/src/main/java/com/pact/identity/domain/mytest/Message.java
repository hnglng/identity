package com.pact.identity.domain.mytest;

import javax.persistence.*;

/**
 * Created by apple on 7/14/14.
 */
@Entity
@Table(name = "test_messages")
public class Message {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   Long id;

    @Column
    String content;

    @OneToOne
    Email email;

    public Message(){

    }

    public Message(String content){
        setContent(content);
    }

    public void setContent(String content){
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
