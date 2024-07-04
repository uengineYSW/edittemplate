package edittemplate.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class PlaceOrderCommand {

    private Long id;
    private String productId;
    private String userId;
    private Integer qty;
    private String productName;
}
