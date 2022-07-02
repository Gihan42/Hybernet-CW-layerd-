package Dao.custom.impl;

import Dao.custom.UserDao;
import Entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.factoryconfiguration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean save(User dto) throws SQLException, ClassNotFoundException, IOException {
        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(dto);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public User search(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, s);

        transaction.commit();
        session.close();

        return user;
    }

    @Override
    public List<User> getAll() throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public boolean update(User dto) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException, IOException {
        return null;
    }
}
