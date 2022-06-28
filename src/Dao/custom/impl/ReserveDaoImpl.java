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
import java.util.List;

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
    public List<Reserve> getAll() throws SQLException, ClassNotFoundException, IOException {
        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List from_reserve_ = session.createQuery("FROM Reserve ").list();
        transaction.commit();
        session.close();
        return from_reserve_;
    }

    @Override
    public boolean update(Reserve dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException, IOException {
        /*Session session = factoryconfiguration.getInstance().getSession();
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
        return id[0] + (Integer.parseInt(id[1]) + 1);*/
        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        NativeQuery sqlQuery = session.createSQLQuery("select res_id from Reserve order by res_id desc limit 1");
        String id = (String) sqlQuery.uniqueResult();
        transaction.commit();
        session.close();
        return id;
    }

    @Override
    public Reserve get(String id) throws Exception {
        Session session = factoryconfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Reserve reserve = session.get(Reserve.class, id);
        transaction.commit();
        session.close();
        return reserve;
    }
}
