package lm.libraryManagementSystem.mapper;

import lm.libraryManagementSystem.model.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    Role findRoleByUsername(String name);

    List<Role> findRoleByUserId(int userId);
}
