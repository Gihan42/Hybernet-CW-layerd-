package Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class Student {
  @Id
  private String student_id;
  private String student_name;
  private String address;
  private String contact_no;
  private String dob;
  private String gender;
  @OneToMany(mappedBy ="student", fetch= FetchType.EAGER )
  private List<Reserve> reserveList=new ArrayList();

  public Student(String student_id, String student_name, String address, String contact_no, String dob, String gender) {
    this.student_id = student_id;
    this.student_name = student_name;
    this.address = address;
    this.contact_no = contact_no;
    this.dob = dob;
    this.gender = gender;
  }
}
