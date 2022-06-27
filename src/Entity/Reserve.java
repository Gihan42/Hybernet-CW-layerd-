package Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class Reserve {
 @Id
 private String res_id;
 private String date;
 private double key_money;
 private String student_id;
 private String room_id;

 @ManyToOne
 private Student student;
 @ManyToOne
 private Room room;
/*
 public Reserve(String res_id, String date, double key_money, String student_id, String room_id) {
  this.res_id = res_id;
  this.date = date;
  this.key_money = key_money;
  this.student_id = student_id;
  this.room_id = room_id;
 }*/
}
