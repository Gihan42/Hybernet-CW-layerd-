package Bo.custom.Iimpl;

import Bo.BOFactory;
import Bo.custom.ReserveBo;
import Dao.DAOFactory;
import Dao.custom.StudentDao;
import Dao.custom.impl.StudentDaoImpl;
import Dto.ReserveDto;
import Dto.RoomsDto;
import Dto.StudentDto;
import Entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReserveBoImpl implements ReserveBo {
        ReserveBo reserveBo= (ReserveBo) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVE);

    @Override
    public boolean saveReserve(ReserveDto dto) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public boolean existReservet(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteReserve(String id) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public StudentDto searchReserve(String id) throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public List<ReserveDto> getAllReserve() throws SQLException, ClassNotFoundException, IOException {
        return null;
    }

    @Override
    public boolean updateReserve(ReserveDto dto) throws SQLException, ClassNotFoundException, IOException {
        return false;
    }

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException {
        String lastID = reserveBo.genarateId();
        if (lastID == null) {
            return "RE0001";
        } else {
            int newID = Integer.parseInt(lastID.substring(1, 4)) + 1;
            if (newID < 10) {
                return "RE000" + newID;
            } else if (newID < 100) {
                return "RE00" + newID;
            } else {
                return "RE" + newID;
            }
        }
    }
}
