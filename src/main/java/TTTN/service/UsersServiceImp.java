package TTTN.service;

import TTTN.dto.UsersDTO;
import TTTN.entity.UsersEntity;
import TTTN.payload.LoginResponse;
import TTTN.repository.UsersRepository;
import TTTN.service.imp.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImp implements UsersService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<UsersDTO> getAllUsers(int userId) {
        List<UsersDTO> listUsers = new ArrayList<>();
        if(usersRepository.findById(userId).getRoleEntity().getRoleName().equals("ADMIN")){
            for(UsersEntity user : usersRepository.findAll()){
                UsersDTO usersDTO = new UsersDTO();
                usersDTO.setFullname(user.getFullname());
                usersDTO.setEmail(user.getEmail());
                usersDTO.setAvatar(user.getAvatar());
                usersDTO.setRoleName(user.getRoleEntity().getRoleName());
                usersDTO.setAccountStatus(user.getStatus());
                usersDTO.setId(user.getId());
                listUsers.add(usersDTO);
            }
            return listUsers;
        }else {
            System.out.println("Loi khi lay danh sach user");
            return null;
        }
    }

    @Override
    public LoginResponse login(String username, String password) {
        LoginResponse loginResponse = new LoginResponse();
        if (usersRepository.findByUsernameAndPassword(username,password).size()>0){
            loginResponse.setLoginSuccess(true);
            loginResponse.setUserId(usersRepository.findByUsernameAndPassword(username,password).get(0).getId());
            return loginResponse;
        }else{
            loginResponse.setLoginSuccess(false);
            return loginResponse;
        }
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
    public UsersDTO showinfo(int userId) {
        UsersEntity user = usersRepository.findById(userId);
        UsersDTO userDTO = new UsersDTO();
        userDTO.setFullname(user.getFullname());
        userDTO.setAvatar(user.getAvatar());
        userDTO.setEmail(user.getEmail());
        userDTO.setBirthday(user.getBirthday());
        userDTO.setRoleName(user.getRoleEntity().getRoleName());
        return userDTO;
    }
    @Override
    public Boolean changeInformation(UsersEntity usersEntity) {
        if(usersRepository.existsById(usersEntity.getId())){
            usersRepository.save(usersEntity);
            return true;
        } else {
            System.out.println("Loi thay doi thong tin nguoi dung");
            return false;
        }
    }
}
