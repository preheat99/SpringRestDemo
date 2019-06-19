package com.example.demo.userData;

import com.example.demo.model.User;

import java.util.HashMap;

public class UserData {
    public static HashMap<Integer, User> userMap = new HashMap<>();
    static
    {
        User u1=new User("Prabhat","Amola",101);
        User u2=new User("Pre","Heat",102);
        User u3=new User("Kanha","Bhaskar",103);
        userMap.put(u1.getId(),u1);
        userMap.put(u2.getId(),u2);
        userMap.put(u3.getId(),u3);
    }
}
