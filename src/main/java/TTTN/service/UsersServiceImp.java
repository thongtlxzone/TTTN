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
    public UsersEntity userdata(int userId) {
        return usersRepository.findById(userId);
    }

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
            loginResponse.setRoleName(usersRepository.findByUsernameAndPassword(username,password).get(0).getRoleEntity().getRoleName());
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
        userDTO.setId(user.getId());
        userDTO.setFullname(user.getFullname());
        userDTO.setAvatar(user.getAvatar());
        userDTO.setEmail(user.getEmail());
        userDTO.setBirthday(user.getBirthday());
        userDTO.setRoleName(user.getRoleEntity().getRoleName());
        return userDTO;
    }
    @Override
    public boolean changeInformation(UsersEntity usersEntity) {
        UsersEntity changedUser = usersRepository.findById(usersEntity.getId());
        if(usersRepository.existsById(usersEntity.getId())){
            changedUser.setId(usersEntity.getId());
            changedUser.setAvatar(usersEntity.getAvatar());
            changedUser.setEmail(usersEntity.getEmail());
            changedUser.setFullname(usersEntity.getFullname());
            changedUser.setBirthday(usersEntity.getBirthday());
            changedUser.setPassword(usersEntity.getPassword());
            changedUser.setRoleEntity(usersEntity.getRoleEntity());
            changedUser.setStatus(usersEntity.getStatus());
            usersRepository.save(changedUser);
            return true;
        } else {
            System.out.println("Loi thay doi thong tin nguoi dung");
            return false;
        }
    }

    @Override
    public List<UsersDTO> searchUserByName(String name) {
        List<UsersEntity> list = usersRepository.searchUsersByFullname(name);
        List<UsersDTO> listUsers = new ArrayList<>();
        for (UsersEntity user : list) {
            UsersDTO temp = new UsersDTO();
            temp.setId(user.getId());
            temp.setAvatar(user.getAvatar());
            temp.setAccountStatus(user.getStatus());
            temp.setRoleName(user.getRoleEntity().getRoleName());
            temp.setEmail(user.getEmail());
            temp.setFullname(user.getFullname());
            temp.setBirthday(user.getBirthday());
            listUsers.add(temp);
        }
        return listUsers;
    }
}
