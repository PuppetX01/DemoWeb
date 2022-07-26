package com.test.demoweb.controller;

import com.test.demoweb.dto.Login;
import com.test.demoweb.dto.User;
import com.test.demoweb.dto.UserLogin;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String Login()
    {
        return "Soy el login";
    }

    @PostMapping("/login")
    public UserLogin postLogin(@RequestBody Login datos)
    {
        if (datos.getEmail().equals("admin@gmail.com") && datos.getPassword().equals("admin")){
            UserLogin res = new UserLogin();
            User user = new User();
            user.setId(1);
            user.setName("Brandon");

            res.setUser(user);
            res.setToken("Soy token");
            return res;
        }
        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Error 401");

    }


    /*@PostMapping("login")
    public Login getLogin(){
        Login login= new Login();
        return login;
    }*/

    /*public RespLogin login(@RequestBody AccessLogin request){
    }*/

}
