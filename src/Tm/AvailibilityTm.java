package Tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AvailibilityTm {
    private String room_id;
    private String type;
    private double monthly_rent;
    private int qty;
}
