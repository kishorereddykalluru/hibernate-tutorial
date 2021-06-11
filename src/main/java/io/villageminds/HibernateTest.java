package io.villageminds;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class HibernateTest {

    public static void main(String[] args) {

        UserDetails user1 = new UserDetails();
        user1.setUserId(1);
        user1.setUserName("kishore");
        user1.setAddress("kishore's address");
        user1.setDescription("description of this user1, " +
                "description of this user2,description of this user3," +
                "description of this user,4description of this user5, description of this user4, description of this user5" +
                "description of this user,4description of this user5, description of this user4, description of this user5" +
                "description of this user,4description of this user5, description of this user4, description of this user5" +
                "description of this user,4description of this user5, description of this user4, description of this user5");
        user1.setJoinedDate(new Date());

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user1);
        session.getTransaction().commit();



    }
}
