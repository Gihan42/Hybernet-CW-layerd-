package Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@Entity
public class Room {
    @Id
    private String room_id;
    private String type;
    private double monthly_rent;
    private int qty;
}
