package br.com.learnspringsecurity.controllers;

import br.com.learnspringsecurity.models.User;
import br.com.learnspringsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> insert(@RequestBody User user) {
        return ResponseEntity.ok(userService.insert(user));
    }

}
