package com.curso.unifal.ecommerce.domain.user.dto;

import com.curso.unifal.ecommerce.domain.address.Address;
import com.curso.unifal.ecommerce.domain.user.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private String firstName;
    private String lastName;
    private String password;
    private String zipCode;
    private Long uidPk;

    public User toEntity(final Address address){
        return User.builder()
                .firstName(this.firstName)
                .lastName(this.lastName)
                .password(this.password)
                .identifier(Math.random())
                .address(address)
                .build();
    }

    public static UserDTO fromEntity(final User user){
        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .zipCode(user.getAddress().getZipCode())
                .build();
    }
}
