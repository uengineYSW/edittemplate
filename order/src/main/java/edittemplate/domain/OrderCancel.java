package edittemplate.domain;

import edittemplate.domain.*;
import edittemplate.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class OrderCancel extends AbstractEvent {

    private Long id;
    private String productId;
    private String userId;
    private Integer qty;
    private String productName;

    public OrderCancel(Order aggregate) {
        super(aggregate);
    }

    public OrderCancel() {
        super();
    }
}
//>>> DDD / Domain Event
