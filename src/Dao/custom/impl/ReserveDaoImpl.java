package Dao.custom.impl;

import Dao.custom.ReserveDao;
import Entity.Reserve;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReserveDaoImpl implements ReserveDao {
    @Override
    public boolean save(Reserve dto) throws SQLException, ClassNotFoundException {
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
    public Reserve search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Reserve> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean update(Reserve dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
