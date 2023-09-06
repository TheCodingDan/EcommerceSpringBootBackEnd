package com.curso.unifal.ecommerce.repository.address;

import com.curso.unifal.ecommerce.domain.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
