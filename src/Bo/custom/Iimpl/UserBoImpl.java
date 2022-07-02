package Bo.custom.Iimpl;

import Bo.custom.UserBo;
import Dao.DAOFactory;
import Dao.custom.UserDao;
import Dto.UserDto;
import Entity.User;

import java.io.IOException;
import java.sql.SQLException;

public class UserBoImpl implements UserBo {
    UserDao userDao= (UserDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    @Override
    public UserDto search(String s) throws SQLException, ClassNotFoundException, IOException {
        User search = userDao.search(s);
        return   new UserDto(search.getUserName(),search.getPassword());

    }


    @Override
    public boolean save(UserDto dto) throws SQLException, ClassNotFoundException, IOException {
        return userDao.save(new User(
                dto.getUsername(),
                dto.getPassword()
        ));
    }
}
