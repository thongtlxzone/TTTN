package TTTN.service;

import TTTN.dto.ProjectDTO;
import TTTN.dto.UsersDTO;
import TTTN.entity.ProjectNUserEntity;
import TTTN.repository.ProjectNUserRepository;
import TTTN.repository.ProjectRepository;
import TTTN.repository.UsersRepository;
import TTTN.service.imp.ProjectNUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectNUserServiceImp implements ProjectNUserService {
    @Autowired
    ProjectNUserRepository projectNUserRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    UsersRepository usersRepository;
    @Override
    public List<ProjectDTO> getAllProjectByUser(int userId) {
        List<ProjectDTO> projectsByUser = new ArrayList<>();
        List<ProjectNUserEntity> list = projectNUserRepository.getAllProjectByUserId(userId);
        for (ProjectNUserEntity projectNUser : list) {
            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setId(projectNUser.getProjectEntity().getId());
            projectDTO.setProjectAvatar(projectNUser.getProjectEntity().getProjectAvatar());
            projectDTO.setProjectName(projectNUser.getProjectEntity().getProjectName());
            projectDTO.setProjectManagerName(projectNUser.getProjectEntity().getProjectManager().getFullname());
            projectDTO.setProjectType(projectNUser.getProjectEntity().getProjectTypeEntity().getProjectTypeName());
            projectDTO.setUserCreatedName(projectNUser.getProjectEntity().getUserCreated());
            projectsByUser.add(projectDTO);
        }
        return projectsByUser;
    }

    @Override
    public List<UsersDTO> getAllUserByProject(int projectId) {
        List<UsersDTO> listUser = new ArrayList<>();
        List<ProjectNUserEntity> list = projectNUserRepository.getAllUserByProjectId(projectId);
        for (ProjectNUserEntity projectNUser : list) {
            UsersDTO user = new UsersDTO();
            user.setId(projectNUser.getUsersEntity().getId());
            user.setFullname(projectNUser.getUsersEntity().getFullname());
            user.setRoleName(projectNUser.getUsersEntity().getRoleEntity().getRoleName());
            user.setAvatar(projectNUser.getUsersEntity().getAvatar());
            user.setEmail(projectNUser.getUsersEntity().getEmail());
            listUser.add(user);
        }
        return listUser;
    }

    @Override
    public boolean createNewProjectNUser(int userId, int projectId) {
        if(projectNUserRepository.getAllByUserIdAndProjectId(userId,projectId).size()==0){
            try{
                ProjectNUserEntity projectNUser = new ProjectNUserEntity();
                projectNUser.setUsersEntity(usersRepository.findById(userId));
                projectNUser.setProjectEntity(projectRepository.findById(projectId));
                projectNUserRepository.save(projectNUser);
                return true;
            }catch (Exception ex){
                System.out.println("Loi luu PNU moi" + ex.getMessage());
                return false;
            }
        }else{
            System.out.println("Loi khi tao PNU");
            return false;
        }
    }
}
