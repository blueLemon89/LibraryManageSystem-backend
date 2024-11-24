package lm.libraryManagementSystem.service;

import lm.libraryManagementSystem.model.User;

import java.util.Map;

public interface UserService {
    void insertUser(Map<String, Object> paramMap);

    int isExistUser(String name);

    User getCurrentUser();

}
