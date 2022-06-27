package Bo.custom;

import Bo.SuperBo;
import Dto.ReserveDto;
import Dto.RoomsDto;
import Dto.StudentDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ReserveBo extends SuperBo {

    boolean saveReserve(ReserveDto dto) throws SQLException, ClassNotFoundException, IOException;
    boolean existReservet(String id)throws SQLException,ClassNotFoundException;
    boolean deleteReserve(String id) throws SQLException, ClassNotFoundException, IOException;
    StudentDto searchReserve(String id) throws SQLException, ClassNotFoundException, IOException;
    List<ReserveDto> getAllReserve() throws SQLException, ClassNotFoundException, IOException;
    boolean updateReserve(ReserveDto dto) throws SQLException, ClassNotFoundException, IOException;
    String genarateId()throws SQLException,ClassNotFoundException;

}
