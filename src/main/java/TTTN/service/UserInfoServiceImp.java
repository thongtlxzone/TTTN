package TTTN.service;

import TTTN.dto.UserInfoDTO;
import TTTN.dto.UsersDTO;
import TTTN.entity.UserInfoEntity;
import TTTN.repository.UserInfoRepository;
import TTTN.service.imp.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImp implements UserInfoService {
    @Autowired
    UserInfoRepository userInfoRepository;
    @Override
    public UserInfoDTO showPersonalInfo(int userId) {
        UserInfoEntity userInfo = userInfoRepository.getReferenceById(userId);
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setFacebook(userInfo.getFacebook());
        userInfoDTO.setJob(userInfo.getJob());
        userInfoDTO.setHobby(userInfo.getHobby());
        userInfoDTO.setMajor(userInfo.getMajor());
        return userInfoDTO;
    }

    @Override
    public boolean creatPersonalInfo(UserInfoEntity userInfo) {
        try{
            userInfoRepository.save(userInfo);
            return true;
        }catch (Exception ex){
            System.out.println("Loi tao thong tin ca nhan" + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean changePersonalInfo(UserInfoEntity userInfo) {
        try{
            if (userInfoRepository.existsById(userInfo.getId())) {
                UserInfoEntity userInfoChanged = userInfoRepository.findById(userInfo.getId()).get();
                userInfoChanged.setId(userInfo.getId());
                userInfoChanged.setFacebook(userInfo.getFacebook());
                userInfoChanged.setHobby(userInfo.getHobby());
                userInfoChanged.setJob(userInfo.getJob());
                userInfoChanged.setHobby(userInfo.getHobby());
                userInfoRepository.save(userInfoChanged);
                return true;
            } else {
                return false;
            }
        }catch (Exception exception){
            System.out.println("Loi thay doi userPersonalInfo " + exception.getMessage());
            return false;
        }
    }
}
