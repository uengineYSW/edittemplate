package edittemplate.domain;

import edittemplate.domain.*;
import edittemplate.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class IncreaseEvent extends AbstractEvent {

    private Long id;
    private Integer stock;

    public IncreaseEvent(Inventory aggregate) {
        super(aggregate);
    }

    public IncreaseEvent() {
        super();
    }
}
//>>> DDD / Domain Event
