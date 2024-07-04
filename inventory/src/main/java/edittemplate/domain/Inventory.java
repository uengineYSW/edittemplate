package edittemplate.domain;

import edittemplate.InventoryApplication;
import edittemplate.domain.StockDecreased;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Inventory_table")
@Data
//<<< DDD / Aggregate Root
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer stock;

    @PostPersist
    public void onPostPersist() {
        StockDecreased stockDecreased = new StockDecreased(this);
        stockDecreased.publishAfterCommit();
    }

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = InventoryApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    //<<< Clean Arch / Port Method
    public void increaseCommand(IncreaseCommandCommand increaseCommandCommand) {
        //implement business logic here:

        IncreaseEvent increaseEvent = new IncreaseEvent(this);
        increaseEvent.publishAfterCommit();
    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
