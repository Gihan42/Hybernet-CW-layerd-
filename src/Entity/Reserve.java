package Entity;

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
public class Reserve {
    @Id
 private String res_id;
 private Date date;
 private double  key_money;
 private String customer_id;
 private String room_id;
}
