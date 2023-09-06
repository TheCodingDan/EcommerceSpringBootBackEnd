package com.curso.unifal.ecommerce.domain.product;

import com.curso.unifal.ecommerce.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "T_PRODUCT")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class Product extends BaseEntity {
    @Id
    @Column(name = "UIDPK", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uidpk;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "SKU", nullable = false)
    private String sku;

    @Column(name = "PRICE", nullable = false)
    private BigDecimal price;
}
