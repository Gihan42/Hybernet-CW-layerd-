package Bo.custom;

import Bo.SuperBo;
import Dto.ReserveDto;
import Dto.RoomsDto;
import Dto.StudentDto;
import Entity.Room;
import Entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProcessBo extends SuperBo {
    ArrayList<StudentDto> getAllStudent() throws SQLException, ClassNotFoundException, IOException;

    ArrayList<RoomsDto> getAllRoom() throws SQLException, ClassNotFoundException, IOException;

    String genarateReserveId() throws SQLException, ClassNotFoundException, IOException;

    boolean purchaseOrder(RoomsDto orderDTO, ArrayList<ReserveDto> reserveDtos) throws SQLException, ClassNotFoundException, IOException;

}
