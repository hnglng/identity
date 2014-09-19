package com.pact.identity.domain.mytest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;


import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by apple on 7/14/14.
 */
public class EntityAndAssociationTest {
    @Test()
    public void testBrokenInversionCode() {
        Long emailId;
        Long messageId;

        Session session = SessionUtil.getSession();
        Transaction tx = session.beginTransaction();

        Email email = new Email("Broken");
        Message message = new Message("Broken");

        email.setMessage(message);
        // message.setEmail(email);

        session.save(email);
        session.save(message);

        emailId = email.getId();
        messageId = message.getId();

        tx.commit();
        session.close();

        assertNotNull(email.getMessage());
        assertNull(message.getEmail());

        session = SessionUtil.getSession();
        tx = session.beginTransaction();

        email = (Email) session.get(Email.class, emailId);
        System.out.println(email);

        message = (Message) session.get(Message.class, messageId);
        System.out.println(message);
    }
}
