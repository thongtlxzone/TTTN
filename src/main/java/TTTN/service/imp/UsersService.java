package TTTN.service.imp;

import TTTN.dto.ProjectDTO;
import TTTN.dto.UsersDTO;
import TTTN.entity.UsersEntity;
import TTTN.payload.LoginResponse;
import org.apache.catalina.User;

import java.util.List;

public interface UsersService {
    List<UsersDTO> getAllUsers(int userId);
    LoginResponse login(String username, String password);
    boolean signup(UsersEntity usersEntity);
    UsersDTO showinfo(int userId);
    Boolean changeInformation(UsersEntity usersEntity);
}