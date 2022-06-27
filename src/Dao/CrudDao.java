package Dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CrudDao <T,Id> extends SuperDao{
    boolean save(T dto) throws SQLException, ClassNotFoundException, IOException;
    boolean exist(Id id) throws SQLException, ClassNotFoundException, IOException;
    boolean delete(Id id) throws SQLException, ClassNotFoundException, IOException;
    T search(Id id) throws SQLException, ClassNotFoundException, IOException;
    List<T> getAll() throws SQLException, ClassNotFoundException, IOException;
    boolean update(T dto) throws SQLException, ClassNotFoundException, IOException;
    String genarateId() throws SQLException, ClassNotFoundException, IOException;
}
