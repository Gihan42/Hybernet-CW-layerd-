package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomsDto {
    private String room_id;
    private String type;
    private double monthly_rent;
    private int qty;
}
