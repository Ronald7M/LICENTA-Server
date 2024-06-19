package com.example.ServerL.Tables.USER;

import com.example.ServerL.ApiResponse;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ApiResponse> createUser(@RequestBody User user){

        int response=userService.createUser(user);
        System.out.println(response);
        if(response==1){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse("The user has not been created, The email is already used",false));
        }
        if(response==2){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse("The user has not been created, The username is already used",false));
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ApiResponse("The user has been created",true));



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
