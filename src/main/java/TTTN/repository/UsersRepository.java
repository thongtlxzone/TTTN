package TTTN.repository;

import TTTN.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
    List<UsersEntity> findByUsernameAndPassword(String username, String password);
    UsersEntity findById(int id);
    @Query(value = "select u form users u where u.fullname like ?1", nativeQuery = true)
    List<UsersEntity> searchUsersByFullname(String fullname);
}
