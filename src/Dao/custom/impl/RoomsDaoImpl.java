package Dao.custom.impl;

import Dao.custom.RoomsDao;
import Entity.Room;
import Entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.factoryconfiguration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomsDaoImpl implements RoomsDao {
    @Override
    public boolean save(Room dto) throws SQLException, ClassNotFoundException, IOException {
        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(dto);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room load = session.load(Room.class, s);
        session.delete(load);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Room search(String s) throws SQLException, ClassNotFoundException, IOException {
        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room room = session.get(Room.class, s);
        transaction.commit();
        session.close();
        return room ;
    }

    @Override
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Room dto) throws SQLException, ClassNotFoundException, IOException {
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
