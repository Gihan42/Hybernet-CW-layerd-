package Dto;

import Entity.Room;
import Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.util.Date;
@Data
@NoArgsConstructor

public class ReserveDto {
    private String res_id;
    private String date;
    private double  key_money;
    private String student_id;
    private String room_id;
    private Student student;
    private Room room;

    /*public ReserveDto(String res_id, String date, double key_money, String student_id, String room_id) {
        this.res_id = res_id;
        this.date = date;
        this.key_money = key_money;
        this.student_id = student_id;
        this.room_id = room_id;
    }*/
}
