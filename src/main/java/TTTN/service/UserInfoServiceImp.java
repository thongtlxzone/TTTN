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
}
