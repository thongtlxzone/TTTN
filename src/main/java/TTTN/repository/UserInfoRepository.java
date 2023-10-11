package TTTN.repository;

import TTTN.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Integer> {
    @Query("select u from userinfo as u where u.usersEntity.id = ?1")
    UserInfoEntity findByUsersEntity(int userId);
}
