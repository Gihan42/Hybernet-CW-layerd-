package Dao.custom.impl;

import Dao.custom.ReserveDao;
import Entity.Reserve;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import util.factoryconfiguration;

import java.io.IOException;
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
    public ArrayList<Reserve> getAll() throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public boolean update(Reserve dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException, IOException {
        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("SELECT res_id FROM `Reserve` ORDER BY oid DESC LIMIT 1;");
         // return sqlQuery.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";*/
        String pid = (String) sqlQuery.uniqueResult();
        transaction.commit();
        session.close();
        return pid;
    }
}
