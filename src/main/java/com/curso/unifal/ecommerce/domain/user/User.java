package com.curso.unifal.ecommerce.domain.user;

import com.curso.unifal.ecommerce.domain.BaseEntity;
import com.curso.unifal.ecommerce.domain.address.Address;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "T_USER")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class User extends BaseEntity {
    @Id
    @Column(name = "UIDPK", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long uidpk;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "PASSWORD", length = 15)
    private String password;

    @Column(name = "IDENTIFIER", nullable = true)
    private  Double identifier;

    @OneToOne
    @JoinColumn(name = "ADDRESS_UIDPK", nullable = false)
    private Address address;



}
