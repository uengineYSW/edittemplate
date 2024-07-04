package edittemplate.domain;

import edittemplate.OrderApplication;
import edittemplate.domain.OrderCancel;
import edittemplate.domain.OrderPlaced;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
//<<< DDD / Aggregate Root
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productId;

    private String userId;

    private Integer qty;

    private String productName;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        edittemplate.external.IncreaseCommandCommand increaseCommandCommand = new edittemplate.external.IncreaseCommandCommand();
        // mappings goes here
        OrderApplication.applicationContext
            .getBean(edittemplate.external.InventoryService.class)
            .increaseCommand(/* get???(), */increaseCommandCommand);

        OrderCancel orderCancel = new OrderCancel(this);
        orderCancel.publishAfterCommit();
    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    //<<< Clean Arch / Port Method
    public void placeOrder(PlaceOrderCommand placeOrderCommand) {
        //implement business logic here:

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
