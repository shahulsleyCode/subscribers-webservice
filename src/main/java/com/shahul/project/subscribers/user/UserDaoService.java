package com.shahul.project.subscribers.user;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    private final static List<User> usersDb = new ArrayList<>();

    static {
        usersDb.add(new User("abc2efg", "Shahul", "admin", LocalDateTime.now(), LocalDateTime.now().plusYears(1)));
        usersDb.add(new User("mtc3tjk", "John", "admin", LocalDateTime.now(), LocalDateTime.now().plusYears(1)));
        usersDb.add(new User("qsx3ert", "Kroos", "admin", LocalDateTime.now(), LocalDateTime.now().plusYears(1)));
    }

    public List<User> listAll() {
        return usersDb;
    }

    public User findUser(String id) {
         User returnUser = null;
         for (User user : usersDb) {
             if (id.equals(user.getUserId())) {
                 returnUser = user;
             }
         }
         return returnUser;
    }

    public void save(User user) {
        usersDb.add(user);
    }

    public void deleteByUserid(String id) {
        usersDb.removeIf(user -> id.equals(user.getUserId()));
    }
        
}