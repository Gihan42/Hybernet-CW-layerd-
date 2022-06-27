package Tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartTm {
    private String res_id;
    private String date;
    private double  key_money;
    private String customer_id;
    private String room_id;

    public CartTm(String res_id, String date, double key_money, String customer_id, String room_id) {
        this.res_id = res_id;
        this.date = date;
        this.key_money = key_money;
        this.customer_id = customer_id;
        this.room_id = room_id;
    }
}
