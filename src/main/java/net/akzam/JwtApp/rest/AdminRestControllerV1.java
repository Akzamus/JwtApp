package net.akzam.JwtApp.rest;

import net.akzam.JwtApp.dto.AdminUserDto;
import net.akzam.JwtApp.model.User;
import net.akzam.JwtApp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin/")
public class AdminRestControllerV1 {
    private final UserService userService;

    public AdminRestControllerV1(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "id") long id) {
        User user = userService.findById(id);
        if(user == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return  new ResponseEntity<>(AdminUserDto.fromUser(user), HttpStatus.OK);
    }
}
