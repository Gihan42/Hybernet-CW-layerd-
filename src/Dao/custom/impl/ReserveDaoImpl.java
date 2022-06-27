package Dao.custom.impl;

import Dao.custom.ReserveDao;
import Entity.Reserve;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import util.factoryconfiguration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReserveDaoImpl implements ReserveDao {
    @Override
    public boolean save(Reserve dto) throws SQLException, ClassNotFoundException, IOException {
       Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(dto);
        transaction.commit();
        session.close();
        return  true;
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
        Query query = session. createQuery("SELECT Reserve.res_id  FROM Reserve ORDER BY res_id DESC");
        query.setMaxResults(1);
        if(query.uniqueResult()==null){
            System.out.println("null");
            return "RS-001";
        }
        String prevId = (String) query.uniqueResult();
        transaction.commit();
        session.close();

        String[] id = prevId.split("-");
        return id[0] + (Integer.parseInt(id[1]) + 1);
    }
}
