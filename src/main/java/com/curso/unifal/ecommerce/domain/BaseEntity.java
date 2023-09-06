package com.curso.unifal.ecommerce.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFIED_AT")
    private Date modifiedAt;

    @PreUpdate
    private void onUpdate(){
        modifiedAt = new Date();
    }

    @PrePersist
    private void onCreate(){
        createdAt = new Date();
        modifiedAt = new Date();
    }
}
