package TTTN.service;

import TTTN.dto.UsersDTO;
import TTTN.entity.UsersEntity;
import TTTN.repository.UsersRepository;
import TTTN.service.imp.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImp implements usersService {
    @Autowired
    UsersRepository usersRepository;
    @Override
    public boolean login(String username, String password) {
        return usersRepository.findByUsernameAndPassword(username,password).size()>0;
    }
    @Override
    public boolean signup(UsersEntity usersEntity){
        //kiem tra username trung nhau trong db
        if(usersRepository.findByUsernameAndPassword(usersEntity.getUsername(),usersEntity.getPassword()).size()>0){
            return false;
        }

        try{
            usersRepository.save(usersEntity);
            return true;
        }catch (Exception ex){
            System.out.println("Loi dang ky: "+ex.getMessage());
            return false;
        }
    }

    @Override
    public UsersDTO showinfo(String username) {
        UsersEntity user = usersRepository.findByUsername(username);
        UsersDTO userDTO = new UsersDTO();
        userDTO.setFullname(user.getFullname());
        userDTO.setAvatar(user.getAvatar());
        userDTO.setEmail(user.getEmail());
        userDTO.setAccountStatus((user.getStatus()));
        userDTO.setRoleName(user.getRoleEntity().getRoleName());
        return userDTO;
    }

}
