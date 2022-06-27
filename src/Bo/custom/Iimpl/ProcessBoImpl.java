package Bo.custom.Iimpl;

import Bo.custom.ProcessBo;
import Dao.DAOFactory;
import Dao.custom.ReserveDao;
import Dao.custom.RoomsDao;
import Dao.custom.StudentDao;
import Dto.ReserveDto;
import Dto.RoomsDto;
import Dto.StudentDto;
import Entity.Room;
import Entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.factoryconfiguration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcessBoImpl implements ProcessBo {
    StudentDao studentDao = (StudentDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    RoomsDao roomsDao = (RoomsDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOMS);
    ReserveDao reserveDao = (ReserveDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVE);

    @Override
    public ArrayList<StudentDto> getAllStudent() throws SQLException, ClassNotFoundException, IOException {
        ArrayList<StudentDto> arrayList = new ArrayList<>();
        List<Student> student = studentDao.getAll();
        for (Student stu : student
        ) {
            arrayList.add(new StudentDto(stu.getStudent_id(), stu.getStudent_name(), stu.getAddress(), stu.getContact_no(), stu.getDob(), stu.getGender()));
        }
        return arrayList;
    }

    @Override
    public ArrayList<RoomsDto> getAllRoom() throws SQLException, ClassNotFoundException, IOException {
        List<Room> arrayList = roomsDao.getAll();
        ArrayList<RoomsDto> dto = new ArrayList<>();
        for (Room room : arrayList
        ) {
            dto.add(new RoomsDto(room.getRoom_id(), room.getType(), room.getMonthly_rent(), room.getQty()));
        }
        return dto;
    }

    @Override
    public String genarateReserveId() throws SQLException, ClassNotFoundException, IOException {
        return reserveDao.genarateId();
    }

    @Override
    public boolean purchaseOrder(RoomsDto roomDTO, ArrayList<ReserveDto> reserveDtos) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

}