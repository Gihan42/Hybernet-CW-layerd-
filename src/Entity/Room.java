package Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data//all are loads
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
    @OneToMany(mappedBy ="room", fetch= FetchType.EAGER )
    private List<Reserve> reserveListRoom=new ArrayList();

    public Room(String room_id, String type, double monthly_rent, int qty) {
        this.room_id = room_id;
        this.type = type;
        this.monthly_rent = monthly_rent;
        this.qty = qty;
    }
}
