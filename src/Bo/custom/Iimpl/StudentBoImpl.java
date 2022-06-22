package Bo.custom.Iimpl;

import Bo.BOFactory;
import Bo.custom.StudentBo;
import Dao.DAOFactory;
import Dao.custom.StudentDao;
import Dto.StudentDto;
import Entity.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentBoImpl implements StudentBo {
    StudentDao studentDao= (StudentDao) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean saveStudent(StudentDto dto) throws SQLException, ClassNotFoundException, IOException {
        return studentDao.save(new Student(
                dto.getStudent_id(),
                dto.getStudent_name(),
                dto.getAddress(),
                dto.getContact_no(),
                dto.getDob(),
                dto.getGender()

        ));
    }

    @Override
    public boolean existStudent(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException, IOException {
      return   studentDao.delete(id);
    }

    @Override
    public StudentDto searchStudent(String id) throws SQLException, ClassNotFoundException, IOException {
        Student search = studentDao.search(id);
        return  new StudentDto(search.getStudent_id(),search.getStudent_name(),search.getAddress(),search.getContact_no(),search.getDob(),search.getGender());

    }

    @Override
    public ArrayList<StudentDto> getAllStudent() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean updateStudent(StudentDto dto) throws SQLException, ClassNotFoundException, IOException {
      return  studentDao.update(new Student(dto.getStudent_id(), dto.getStudent_name(),dto.getAddress(),dto.getContact_no(),dto.getDob(),dto.getGender()));
    }

    @Override
    public String genarateId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
