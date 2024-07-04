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
// @RequestMapping(value="/orders")
@Transactional
public class OrderController {
    @Autowired
    OrderRepository orderRepository;




    @RequestMapping(value = "/orders",
            method = RequestMethod.POST,
            produces = "application/json;charset=UTF-8")
    public Order placeOrder(HttpServletRequest request, HttpServletResponse response, 
        @RequestBody PlaceOrderCommand placeOrdercommand) throws Exception {
            System.out.println("##### /order/placeOrder  called #####");
            Order order = New Order();
            order.placeOrder(placeOrdercommand);
            orderRepository.save(order);
            return order;
    }


}
//>>> Clean Arch / Inbound Adaptor
