package com.curso.unifal.ecommerce.services.address;

import com.curso.unifal.ecommerce.client.viacep.ViaCepClient;
import com.curso.unifal.ecommerce.domain.address.Address;
import com.curso.unifal.ecommerce.domain.user.viacep.dto.ViaCepDTO;
import com.curso.unifal.ecommerce.repository.address.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final ViaCepClient viaCepClient;

    public Address save(ViaCepDTO viaCepDTO){
        return addressRepository.save(Address.builder()
                .zipCode(viaCepDTO.getCep())
                .publicPlace(viaCepDTO.getLogradouro())
                .fu(viaCepDTO.getUf())
                .neighborhood(viaCepDTO.getBairro())
                .adjunct(viaCepDTO.getComplemento())
                .ddd(viaCepDTO.getDdd())
                .locality(viaCepDTO.getLocalidade())
                .build());
    }

    public Address saveAddressByZipCode(String zipCode){
        return save(viaCepClient.getZipCodeByZipCode(zipCode));
    }
}
