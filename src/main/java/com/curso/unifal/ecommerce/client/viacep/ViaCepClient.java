package com.curso.unifal.ecommerce.client.viacep;

import com.curso.unifal.ecommerce.domain.user.viacep.dto.ViaCepDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "via-cep-client", url = "https://viacep.com.br")
public interface ViaCepClient {
    @GetMapping(path = "/ws/{zipCode}/json")
    ViaCepDTO getZipCodeByZipCode(@PathVariable String zipCode);
}
