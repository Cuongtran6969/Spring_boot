package com.example.demo2.controller;

import com.example.demo2.dto.request.UserRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping(value = "/", headers = "apiKey=v1.0")
//    @RequestMapping(method = RequestMethod.POST, path = "", headers = "apiKey=v1.0")
    public String addUser(@RequestBody UserRequestDTO userDTO) {
        return "User added";
    }

    @PutMapping("{userId}")
    public String updateUser(@PathVariable int userId, @RequestBody(required = false) UserRequestDTO userDTO) {
        System.out.println("Request update userId = "+userId);
        return "User updated";
    }

    @PatchMapping("{userId}")
    public String changeStatus(@PathVariable int userId, @RequestParam boolean status) {
        System.out.println("Request change user status, userId = "+userId);
        return "User status updated";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId) {
        System.out.println("Request delete user status, userId = "+userId);
        return "Deleted user";
    }

    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable int userId) {
        System.out.println("Request get user status, userId = "+userId);
        return new UserRequestDTO("firsName", "lastName", "email", "phone");
    }

    @GetMapping("/list")
    public List<UserRequestDTO> getAllUsers(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        System.out.println("Request get all user ");
        return List.of(new UserRequestDTO("firsName", "lastName", "email", "phone"));
    }
}
