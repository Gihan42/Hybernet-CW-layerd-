package util;

import Entity.Reserve;
import Entity.Room;
import Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;

public class factoryconfiguration {
    private static factoryconfiguration factoryconfiguration;
    private SessionFactory sessionFactory;

    private factoryconfiguration() throws IOException {
        Properties p = new Properties();
        p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("hibernate.properties"));
        Configuration configuration = new Configuration().setProperties(p).addAnnotatedClass(Student.class).
                addAnnotatedClass(Reserve.class).addAnnotatedClass(Room.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static factoryconfiguration getInstance() throws IOException {
        if(factoryconfiguration==null){
            factoryconfiguration=new factoryconfiguration();
        }
        return factoryconfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
