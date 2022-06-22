package Bo.custom.Iimpl;

import Bo.custom.RoomsBo;
import Dao.DAOFactory;
import Dao.custom.RoomsDao;
import Dto.RoomsDto;
import Entity.Room;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomsBoImpl implements RoomsBo {
    RoomsDao roomsDao= ( RoomsDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOMS);

    @Override
    public boolean saveRooms(RoomsDto dto) throws SQLException, ClassNotFoundException, IOException {
       return roomsDao.save(new Room(dto.getRoom_id(), dto.getType(), dto.getMonthly_rent(), dto.getQty()));
    }

    @Override
    public boolean existRooms(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteRooms(String id) throws SQLException, ClassNotFoundException, IOException {
        return  roomsDao.delete(id);
    }

    @Override
    public RoomsDto searchRooms(String id) throws SQLException, ClassNotFoundException, IOException {
        Room room=roomsDao.search(id);
        return  new RoomsDto( room.getRoom_id(),room.getType(),room.getMonthly_rent(),room.getQty());
    }

    @Override
    public ArrayList<RoomsDto> getAllRoomst() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean updateRoomst(RoomsDto dto) throws SQLException, ClassNotFoundException, IOException {
        return roomsDao.update(new Room(dto.getRoom_id(), dto.getType(), dto.getMonthly_rent(), dto.getQty()));
    }

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
