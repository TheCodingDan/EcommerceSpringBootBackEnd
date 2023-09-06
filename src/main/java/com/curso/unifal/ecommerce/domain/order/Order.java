package com.curso.unifal.ecommerce.domain.order;

import com.curso.unifal.ecommerce.domain.BaseEntity;
import com.curso.unifal.ecommerce.domain.product.Product;
import com.curso.unifal.ecommerce.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "T_ORDER")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Order extends BaseEntity {
    @Id
    @Column(name = "UIDPK", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uidPk;

    @OneToOne
    @JoinColumn(name = "USER_UID", nullable = false)
    private User user;

    @OneToMany
    @JoinColumn(name = "ORDER_UID")
    private List<Product> products;

    @Column(name = "TOTAL", nullable = false)
    private BigDecimal total;
}
