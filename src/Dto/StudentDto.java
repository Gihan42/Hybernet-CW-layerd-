package Dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
public class StudentDto {
        private String student_id;
        private String student_name;
        private String address;
        private String contact_no;
        private String dob;
        private String gender;


}
