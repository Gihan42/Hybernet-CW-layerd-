package Bo.custom;

import Bo.SuperBo;
import Dto.UserDto;
import Entity.User;

import java.io.IOException;
import java.sql.SQLException;

public interface UserBo extends SuperBo {
    public UserDto search(String s) throws SQLException, ClassNotFoundException, IOException;
    public boolean save(UserDto dto) throws SQLException, ClassNotFoundException, IOException;
}
