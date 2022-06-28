package Bo.custom.Iimpl;

import Bo.BOFactory;
import Bo.custom.ReserveBo;
import Dao.DAOFactory;
import Dao.custom.ReserveDao;
import Dao.custom.StudentDao;
import Dao.custom.impl.StudentDaoImpl;
import Dto.ReserveDto;
import Dto.RoomsDto;
import Dto.StudentDto;
import Entity.Reserve;
import Entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.factoryconfiguration;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReserveBoImpl implements ReserveBo {
    ReserveDao reserveBo= (ReserveDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVE);

    @Override
    public boolean saveReserve(ReserveDto dto) throws SQLException, ClassNotFoundException, IOException {
      return  reserveBo.save(new Reserve(dto.getRes_id(),dto.getDate(),dto.getKey_money(),dto.getRoom_id(),dto.getStudent_id())) ;

    }

    @Override
    public boolean existReservet(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteReserve(String id) throws SQLException, ClassNotFoundException, IOException {
        return reserveBo.delete(id);
    }

    @Override
    public StudentDto searchReserve(String id) throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public List<ReserveDto> getAllReserve() throws SQLException, ClassNotFoundException, IOException {
        List<Reserve> arrayList = reserveBo.getAll();
        ArrayList<ReserveDto> reserveDtos = new ArrayList<>();
        for (Reserve reserve : arrayList) {
            reserveDtos.add(new ReserveDto(reserve.getRes_id(), reserve.getDate(), reserve.getKey_money(), reserve.getStudent_id(), reserve.getRoom_id()));
        }
        return reserveDtos;

    }


    @Override
    public boolean updateReserve(ReserveDto dto) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException, IOException {
        String lastID = reserveBo.genarateId();
        System.out.println(lastID);
        if (lastID == null) {
            return "R001";
        } else {
            int newID = Integer.parseInt(lastID.substring(1, 4)) + 1;
            if (newID < 10) {
                return "R00" + newID;
            } else if (newID < 100) {
                return "R0" + newID;
            } else {
                return "R" + newID;
            }
        }
    }


}
