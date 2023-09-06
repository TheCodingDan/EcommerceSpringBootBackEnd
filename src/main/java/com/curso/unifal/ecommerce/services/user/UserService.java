package com.curso.unifal.ecommerce.services.user;

import com.curso.unifal.ecommerce.domain.address.Address;
import com.curso.unifal.ecommerce.domain.user.User;
import com.curso.unifal.ecommerce.domain.user.dto.UserDTO;
import com.curso.unifal.ecommerce.repository.user.UserRepository;
import com.curso.unifal.ecommerce.services.address.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final AddressService addressService;
    public void save(UserDTO userDTO){
        Address savedAddress = addressService.saveAddressByZipCode(userDTO.getZipCode());
        userRepository.save(userDTO.toEntity(savedAddress));
    }

    public List<UserDTO> getUsersByFirstName(final String firstName){
        List<UserDTO> usersDTO = new ArrayList<>();
        Optional<List<User>> userList = userRepository.getUsersByFirstName(firstName);

        if(userList.isPresent()){
            for (User user : userList.get()){
                usersDTO.add(UserDTO.fromEntity(user));
            }
        }
        return usersDTO;
    }
    public User findByUid(Long uidPk){
        return userRepository.findById(uidPk).get();
    }

    public UserDTO updateUser(UserDTO userDTO){
        Optional<User> userOptional = userRepository.findById(userDTO.getUidPk());
        if(userOptional.isPresent()){
            User user = userOptional.get();
            if(userDTO.getFirstName() != null){
                user.setFirstName(userDTO.getFirstName());
            }
            if(userDTO.getLastName() != null){
                user.setLastName(userDTO.getLastName());
            }
            if(userDTO.getZipCode() != null){
                user.setAddress(addressService.saveAddressByZipCode(userDTO.getZipCode()));
            }
            if(userDTO.getPassword() != null){
                user.setPassword(userDTO.getPassword());
            }
            return UserDTO.fromEntity(userRepository.save(user));
        }
        throw new RuntimeException("USER NOT FOUND");

    }

    public void deleteUserByUidPk(Long uidPk){
        Optional<User> userOptional = userRepository.findById(uidPk);

        if(userOptional.isPresent()){
            userRepository.delete(userOptional.get());
            return;
        }
        throw new RuntimeException("USER NOT FOUND");
    }
}
