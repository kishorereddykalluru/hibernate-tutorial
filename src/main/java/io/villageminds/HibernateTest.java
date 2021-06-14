package io.villageminds;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

    public static void main(String[] args) {

        UserDetails1 user1 = new UserDetails1();
        user1.setUserName("kishore");

        Address homeAddress = new Address();
        homeAddress.setState("andhra");
        homeAddress.setCity("kadapa");
        homeAddress.setPincode("516002");
        homeAddress.setStreet("blind school");
        Address officeAddress = new Address();
        officeAddress.setState("telangana");
        officeAddress.setCity("hyderabad");
        officeAddress.setPincode("500032");
        officeAddress.setStreet("gachibowli");

        user1.getListOfAddress().add(homeAddress);
        user1.getListOfAddress().add(officeAddress);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user1);
        session.getTransaction().commit();
        session.close();

        user1 = null;

        session = sessionFactory.openSession();
        user1 = (UserDetails1) session.get(UserDetails1.class, 1);
        session.close();
        System.out.println(user1.getListOfAddress().size());

    }
}
