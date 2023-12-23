package demo.demo.service;

import demo.demo.entity.user;
import org.apache.catalina.User;

import java.util.List;

public interface userservice {
    user createUser(user User);

    user getUserById(Long userId);

    List<user>getAlluser();

    user updateUser(user User);

    void deleteuser(Long userId);
}
