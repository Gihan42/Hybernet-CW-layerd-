package Dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class StudentDto {
        @Id
        private String student_id;
        private String student_name;
        private String address;
        private String contact_no;
        private Date dob;
        private String gender;
}
