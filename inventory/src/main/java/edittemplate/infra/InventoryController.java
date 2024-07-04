package edittemplate.infra;
import edittemplate.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/inventories")
@Transactional
public class InventoryController {
    @Autowired
    InventoryRepository inventoryRepository;




    @RequestMapping(value = "/inventories",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public Inventory increaseCommand(HttpServletRequest request, HttpServletResponse response, 
        @RequestBody IncreaseCommandCommand increaseCommandcommand) throws Exception {
            System.out.println("##### /inventory/increaseCommand  called #####");
            Inventory inventory = New Inventory();
            inventory.increaseCommand(increaseCommandcommand);
            inventoryRepository.save(inventory);
            return inventory;
    }

}
//>>> Clean Arch / Inbound Adaptor
