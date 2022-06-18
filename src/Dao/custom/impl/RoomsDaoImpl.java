package Dao.custom.impl;

import Dao.custom.RoomsDao;
import Entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomsDaoImpl implements RoomsDao {
    @Override
    public boolean save(Room dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Room search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Room dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
