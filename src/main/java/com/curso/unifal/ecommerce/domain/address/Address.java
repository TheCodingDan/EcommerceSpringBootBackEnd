package com.curso.unifal.ecommerce.domain.address;

import com.curso.unifal.ecommerce.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "T_ADDRESS")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class Address extends BaseEntity {
    @Id
    @Column(name = "UIDPK", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uidPk;

    @Column(name = "ZIPCODE", nullable = true)
    private String zipCode;

    @Column(name = "PUBLIC_PLACE", nullable = true)
    private String publicPlace;

    @Column(name = "ADJUNCT", nullable = true)
    private String adjunct;

    @Column(name = "NEIGHBORHOOD", nullable = true)
    private String neighborhood;

    @Column(name = "LOCALITY", nullable = true)
    private String locality;

    @Column(name = "FEDERAL_UNIT", nullable = true)
    private String fu;

    @Column(name = "DDD", nullable = true)
    private String ddd;

}
