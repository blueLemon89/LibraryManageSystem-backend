package lm.libraryManagementSystem.mapper;

import lm.libraryManagementSystem.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserMapper {

    User findUserById(int id);

    User findUserByUsername(String name);

    User findUserByEmail(String email);

    User findRoleByUserId(int id);

    int isUserExistWithUsername(String name);

    boolean isUserExistWithEmail(String email);

    void insertUser(Map<String, Object> paramMap);

    void updateUser(Map<String, Object> paramMap);

    void deleteUser(Map<String, Object> paramMap);

}
