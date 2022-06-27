package Bo.custom;

import Bo.SuperBo;
import Dto.StudentDto;
import Entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface StudentBo extends SuperBo {
    boolean saveStudent(StudentDto dto) throws SQLException, ClassNotFoundException, IOException;
    boolean existStudent(String id) throws SQLException, ClassNotFoundException, IOException;
    boolean deleteStudent(String id) throws SQLException, ClassNotFoundException, IOException;
    StudentDto searchStudent(String id) throws SQLException, ClassNotFoundException, IOException;
    List<StudentDto> getAllStudent() throws SQLException, ClassNotFoundException, IOException;
    boolean updateStudent(StudentDto dto) throws SQLException, ClassNotFoundException, IOException;
    String genarateId()throws SQLException,ClassNotFoundException;
}
