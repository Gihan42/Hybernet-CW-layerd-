package Tm;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomTm {
    private String room_id;
    private String type;
    private double monthly_rent;
    private int qty;
}
