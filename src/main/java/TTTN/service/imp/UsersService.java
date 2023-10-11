package TTTN.service.imp;

import TTTN.dto.UsersDTO;
import TTTN.entity.UsersEntity;
import org.apache.catalina.User;

public interface UsersService {
    boolean login(String username, String password);
    boolean signup(UsersEntity usersEntity);
    UsersDTO showinfo(String username);
    Boolean changeInformation(UsersEntity usersEntity);
}
