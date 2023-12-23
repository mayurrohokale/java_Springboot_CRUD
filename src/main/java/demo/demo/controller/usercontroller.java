package demo.demo.controller;

import demo.demo.entity.user;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import demo.demo.service.userservice;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class usercontroller {
    private userservice userService;
    // build create rest API
    @PostMapping
    public ResponseEntity<user> createUser(@RequestBody user User){
        user saveuser = userService.createUser(User);
        return new ResponseEntity<>(saveuser, HttpStatus.CREATED);
    }

    //build get user by id REST API
    //http://localhost:5454/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<user>getUserByID(@PathVariable("id") Long userId){
         user User =userService.getUserById(userId);
        return new ResponseEntity<>(User,HttpStatus.OK);
    }

    //build get all user REST API
    //http://localhost:5454/api/users/1
    @GetMapping
    public ResponseEntity<List<user>>getAllUser(){
        List<user> users = userService.getAlluser();
        return new ResponseEntity<>(users, HttpStatus.OK);

    }
    //build update user REST API
    //http://localhost:5454/api/users/1
    @PutMapping("{id}")
    public ResponseEntity<user>updateuser(@PathVariable("id") Long userId,@RequestBody user User)
    {
        User.setId(userId);
        user updateduser = userService.updateUser(User);
        return new ResponseEntity<>(updateduser, HttpStatus.OK);
    }

    // build delete user REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteuser(@PathVariable("id") Long userId){
        userService.deleteuser(userId);
        return new ResponseEntity<>("User Succesfully Deleted", HttpStatus.OK);
    }
}
