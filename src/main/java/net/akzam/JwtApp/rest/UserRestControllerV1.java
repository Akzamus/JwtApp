package net.akzam.JwtApp.rest;

import net.akzam.JwtApp.dto.UserDto;
import net.akzam.JwtApp.model.User;
import net.akzam.JwtApp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users/")
public class UserRestControllerV1 {
    private final UserService userService;

    public UserRestControllerV1(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") long id) {
        User user = userService.findById(id);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return  new ResponseEntity<>(UserDto.fromUser(user), HttpStatus.OK);
    }
}
