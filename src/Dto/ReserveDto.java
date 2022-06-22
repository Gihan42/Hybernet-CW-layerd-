package Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReserveDto {
    private String res_id;
    private Date date;
    private double  key_money;
    private String customer_id;
    private String room_id;
}
