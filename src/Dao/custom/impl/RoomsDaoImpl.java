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
import java.util.List;

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
    public List<Room> getAll() throws SQLException, ClassNotFoundException, IOException {
        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Room> list = session.createQuery("FROM Room ").list();
        transaction.commit();
        session.close();
        return list;
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

    @Override
    public boolean updateRoomsQty(String room_id, int qty) throws SQLException, ClassNotFoundException, IOException {
        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("UPDATE Room SET qty=qty-qty WHERE room_id=room_id");
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public void updateRqty(Room entity) throws SQLException, ClassNotFoundException, IOException {

        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Room room=session.get(Room.class,entity.getRoom_id()) ;
        room.setQty(entity.getQty());
        transaction.commit();
        session.close();
    }
}
