package TTTN.service.imp;

import TTTN.dto.UserInfoDTO;
import TTTN.entity.UserInfoEntity;

public interface UserInfoService {
    UserInfoDTO showPersonalInfo(int userId);
    boolean creatPersonalInfo(UserInfoEntity userInfo);
    boolean changePersonalInfo(UserInfoEntity userInfo);

}
