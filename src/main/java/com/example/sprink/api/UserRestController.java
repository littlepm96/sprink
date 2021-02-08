package com.example.sprink.api;

import java.security.Principal;
import java.util.List;

import com.example.sprink.common.security.JWTUtil;
import com.example.sprink.domain.UserRequest;
import com.example.sprink.domain.UserResponse;
import com.example.sprink.domain.User;
import com.example.sprink.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@CrossOrigin(origins = {"http://localhost:8100","http://10.0.2.2:8080/"})
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private IUserService userService;
    @Autowired
    private JWTUtil util;
    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping ("/all")
public  @ResponseBody
    List<User> getall(){return userService.findAll();}
    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody User user) {

        Integer id = userService.saveUser(user);
        String message= "User with id '"+id+"' saved succssfully!";
        //return new ResponseEntity<String>(message, HttpStatus.OK);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/loginUser")
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest request){

        //Validate username/password with DB(required in case of Stateless Authentication)
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(), request.getPassword()));
        String token =util.generateToken(request.getUsername());
        return ResponseEntity.ok(new UserResponse(token,"Token generated successfully!"));
    }

    @PostMapping("/getData")
    public ResponseEntity<String> testAfterLogin(Principal p){
        return ResponseEntity.ok("You are accessing data after a valid Login. You are :" +p.getName());
    }
}