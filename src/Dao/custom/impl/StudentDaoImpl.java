package Dao.custom.impl;

import Dao.custom.StudentDao;
import Entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import util.factoryconfiguration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public boolean save(Student dto) throws SQLException, ClassNotFoundException, IOException {
        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(dto);

        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException, IOException {
        /*Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql="FROM Student WHERE student_id=s";
        List<Student> list = session.createQuery(hql).list();

        transaction.commit();
        session.close();*/
        /*Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("SELECT student_id FROM Student WHERE student_id=student_id");
        String pid = (String) sqlQuery.uniqueResult();
        transaction.commit();
        session.close();*/
        return true;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student load = session.load(Student.class, s);
        session.delete(load);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student search(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, s);
        transaction.commit();
        session.close();
        return student;
    }

    @Override
    public List getAll() throws SQLException, ClassNotFoundException, IOException {
        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        String hql="FROM Student";
        Query query = session.createQuery(hql);
        List list = query.list();
        transaction.commit();
        session.close();
        return  list;
    }

    @Override
    public boolean update(Student dto) throws SQLException, ClassNotFoundException, IOException {
        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(dto);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
