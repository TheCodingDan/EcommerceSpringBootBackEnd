package com.curso.unifal.ecommerce.controller.user;

import com.curso.unifal.ecommerce.domain.user.dto.UserDTO;
import com.curso.unifal.ecommerce.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    @PostMapping(path = "/v1/user")
    public void createUser(@RequestBody UserDTO userDTO){
        userService.save(userDTO);
    }

    @GetMapping(path = "/v1/user")
    public ResponseEntity<List<UserDTO>> getUsersByFirstName(@RequestParam String firstName){
        return ResponseEntity.ok(userService.getUsersByFirstName(firstName));
    }

    @PutMapping(path = "v1/user")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.updateUser(userDTO));
    }

    @DeleteMapping(path = "v1/user")
    public void deleteUserByUidPk(@RequestParam Long uidPk){
        userService.deleteUserByUidPk(uidPk);
    }
}
