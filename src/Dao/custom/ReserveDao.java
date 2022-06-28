package Dao.custom;

import Dao.CrudDao;
import Entity.Reserve;

public interface ReserveDao extends CrudDao<Reserve,String> {
    public Reserve get(String id) throws Exception;
}
