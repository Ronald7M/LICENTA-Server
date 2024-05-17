package com.example.ServerL.Tables.USER;

import com.example.ServerL.AUTORIZATION.JwtUtil;
import io.jsonwebtoken.Jwt;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/user")
public class UserController {

   private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
      return userService.getUsers();
    }

    @PostMapping
    public void createUser(@RequestBody User user){

        userService.createUser(user);

    }
    @PutMapping(path="{id}")
    public void updateUser(@PathVariable int id,@RequestBody User user){
        userService.updateUser(id,user);

    }
    @DeleteMapping(path="{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }


}
