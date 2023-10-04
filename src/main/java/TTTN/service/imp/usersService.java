package TTTN.service.imp;

import TTTN.controller.UsersController;
import TTTN.dto.UsersDTO;
import TTTN.entity.UsersEntity;

public interface usersService {
    boolean login(String username, String password);
    boolean signup(UsersEntity usersEntity);
    UsersDTO showinfo(String username);
}
