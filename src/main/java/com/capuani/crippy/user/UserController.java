package com.capuani.crippy.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<User> getUsers () {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    User getUser (@PathVariable long id) {
        return userService.getUserByID(id);
    }

    @PostMapping("/create")
    User createUser (@RequestParam String name, @RequestParam String email) {
        return userService.createUser(name, email);
    }

    @PutMapping("/add_alert/{id}/{user_id}")
    User addUserAlert (@PathVariable long id, @PathVariable long user_id) {
        return userService.addUserAlert(id, user_id);
    }


}
