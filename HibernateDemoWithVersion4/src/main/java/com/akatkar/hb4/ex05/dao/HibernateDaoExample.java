package com.akatkar.hb4.ex05.dao;

import com.akatkar.hb4.HibernateUtil;
import com.akatkar.hb4.ex04.onetoone.Person;
import com.akatkar.hb4.ex04.onetoone.PersonDetail;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ali-Katkar
 */
public class HibernateDaoExample {

    public static void main(String[] args) {
        
        HibernateUtil.initialize(Person.class, PersonDetail.class);
        
        PersonDao personDao = new PersonDao();

        testPersonDao(personDao);

        testCriteria(personDao);
        
        personDao.close();                        
    }

    private static void testPersonDao(PersonDao personDao){
        
        PersonDetail pd = new PersonDetail("Ankara");
        Person person = new Person("test person", pd);
        personDao.create(person);

        PersonDetail pd2 = new PersonDetail("Balıkesir");
        Person person2 = new Person("test person 2", pd2);
        personDao.create(person2);

        List<Person> list = personDao.findAll();

        for (Person pr : list) {
            System.out.println(pr.getName());
        }

        Person x = personDao.find(1);
        System.out.println(x.getName());
        
        x.setName("changed name");
        personDao.update(x);
        
        Person y = personDao.find(1);
        System.out.println(y.getName());
        
        personDao.delete(y);
        
    }
    
    private static void testCriteria(PersonDao personDao){
        
        testAddData(personDao);
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Criteria cr = session.createCriteria(Person.class);
        
        cr.add(Restrictions.gt("age", 50));
        
        List<Person>  resultList =  cr.list();
        
        for(Person p : resultList){
            System.out.println(p);
        }        
    }
    
    private static void testAddData(PersonDao personDao) {
        for (int i = 0; i < 100; i++) {
            PersonDetail personDetail = new PersonDetail("2001");
            Person person = new Person("test " + i, personDetail);
            person.setAge((int)(100 * Math.random()));
            personDao.create(person);
        }
    }
}
