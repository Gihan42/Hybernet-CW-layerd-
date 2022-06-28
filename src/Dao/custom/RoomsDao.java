package Dao.custom;

import Dao.CrudDao;
import Entity.Room;

import java.io.IOException;
import java.sql.SQLException;

public interface RoomsDao extends CrudDao<Room,String> {
    public boolean updateRoomsQty(String r_id, int qty) throws SQLException, ClassNotFoundException, IOException ;
}
