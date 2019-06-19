package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.userData.UserData;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    HashMap<Integer, User> userHash= UserData.userMap;
    List<User> users=new ArrayList<>();
    @GetMapping("/users")
    public List<User> getAll()
    {
        for (Map.Entry<Integer,User> entry : userHash.entrySet())
        {
            User user=entry.getValue();
            users.add(user);
        }
        return users;
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable Integer id)
    {
        return userHash.get(id);
    }
    @PostMapping("/user")
    public Boolean createUser(@RequestBody User user)
    {
        if(userHash.containsKey(user.getId()))
        {
            return false;
        }
        else
        {userHash.put(user.getId(),user);
        return true;}
    }
    @DeleteMapping("/user/{id}")
    public Boolean deleteUser(@PathVariable Integer id)
    {
        if(userHash.containsKey(id))
        {
            userHash.remove(id);
            return true;
        }
        else
            return false;

    }
    @PutMapping("/user")
    public User updateUser(@RequestBody User user)
    {
        Integer id=user.getId();
        if(userHash.containsKey(id))
        {
            userHash.put(id,user);
            return userHash.get(id);
        }
        else
            return null;
    }
}
