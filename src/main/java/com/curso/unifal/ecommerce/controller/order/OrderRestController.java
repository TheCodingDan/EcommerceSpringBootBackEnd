package com.curso.unifal.ecommerce.controller.order;

import com.curso.unifal.ecommerce.domain.order.dto.OrderDTO;
import com.curso.unifal.ecommerce.services.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderRestController {
    private final OrderService orderService;

    @PostMapping(path = "v1/checkout")
    public void checkout(@RequestBody OrderDTO orderDTO){
        orderService.checkout(orderDTO);
    }
}
