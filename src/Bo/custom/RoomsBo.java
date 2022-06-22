package Bo.custom;

import Bo.SuperBo;
import Dto.RoomsDto;
import Dto.StudentDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomsBo extends SuperBo {
    boolean saveRooms(RoomsDto dto) throws SQLException, ClassNotFoundException, IOException;
    boolean existRooms(String id)throws SQLException,ClassNotFoundException;
    boolean deleteRooms(String id) throws SQLException, ClassNotFoundException, IOException;
    RoomsDto searchRooms(String id) throws SQLException, ClassNotFoundException, IOException;
    ArrayList<RoomsDto> getAllRoomst()throws SQLException,ClassNotFoundException;
    boolean updateRoomst(RoomsDto dto) throws SQLException, ClassNotFoundException, IOException;
    String genarateId()throws SQLException,ClassNotFoundException;
}
