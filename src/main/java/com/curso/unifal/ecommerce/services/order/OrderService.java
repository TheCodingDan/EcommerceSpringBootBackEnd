package com.curso.unifal.ecommerce.services.order;

import com.curso.unifal.ecommerce.domain.order.Order;
import com.curso.unifal.ecommerce.domain.order.dto.OrderDTO;
import com.curso.unifal.ecommerce.domain.product.Product;
import com.curso.unifal.ecommerce.domain.user.User;
import com.curso.unifal.ecommerce.domain.user.dto.UserDTO;
import com.curso.unifal.ecommerce.repository.order.OrderRepository;
import com.curso.unifal.ecommerce.services.product.ProductService;
import com.curso.unifal.ecommerce.services.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductService productService;
    private final UserService userService;
    public void checkout(final OrderDTO orderDTO){
        List<String> skus = orderDTO.getProductsSkus();
        List<Product> products = new ArrayList<>();

        for(String sku : skus){
            try{
                products.add(productService.findProductBySku(sku));
            } catch(Exception ex){
                log.error("Product [{}] not found", sku);
            }
        }

        if(products.isEmpty()){
            throw new IllegalArgumentException("None of the skus are valid");
        }

        User user;
        try{
            user = userService.findByUid(orderDTO.getUserUid());
        } catch(NullPointerException e){
            log.error("User not found");
            return;
        }

        Order order = Order.builder()
                .user(user)
                .products(products)
                .total(getTotal(products))
                .build();
        orderRepository.save(order);
    }

    private BigDecimal getTotal(List<Product> products){
        BigDecimal total = BigDecimal.ZERO;

        for(Product product : products){
            total = total.add((product.getPrice()));
        }
        if(total.compareTo(BigDecimal.ZERO) == 0){
            throw new RuntimeException("TOTAL EQUALS ZERO");
        }

        return total;
    }

}
