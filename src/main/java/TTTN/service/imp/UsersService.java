package TTTN.service.imp;

import TTTN.dto.ProjectDTO;
import TTTN.dto.UsersDTO;
import TTTN.entity.UsersEntity;
import TTTN.payload.LoginResponse;
import org.apache.catalina.User;

public interface UsersService {
    LoginResponse login(String username, String password);
    boolean signup(UsersEntity usersEntity);
    UsersDTO showinfo(String username);
    Boolean changeInformation(UsersEntity usersEntity);
}
