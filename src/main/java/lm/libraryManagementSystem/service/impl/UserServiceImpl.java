package lm.libraryManagementSystem.service.impl;

import lm.libraryManagementSystem.mapper.UserMapper;
import lm.libraryManagementSystem.model.User;
import lm.libraryManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public void insertUser(Map<String, Object> paramMap) {
        userMapper.insertUser(paramMap);
    }

    public int isExistUser(String name) {
        return userMapper.isUserExistWithUsername(name);
    }

    public User getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userMapper.findUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

}
