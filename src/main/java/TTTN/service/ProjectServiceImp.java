package TTTN.service;

import TTTN.dto.ProjectDTO;
import TTTN.entity.ProjectEntity;
import TTTN.repository.ProjectRepository;
import TTTN.service.imp.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Override
    public ProjectDTO showProject(int projectId) {
        ProjectEntity project = projectRepository.findById(projectId);
        ProjectDTO showPrj = new ProjectDTO();
        showPrj.setId(project.getId());
        showPrj.setProjectName(project.getProjectName());
        showPrj.setProjectAvatar(project.getProjectAvatar());
        showPrj.setProjectType(project.getProjectTypeEntity().getProjectTypeName());
        showPrj.setProjectManagerName(project.getProjectManager().getFullname());
        return showPrj;
    }

    @Override
    public boolean createProject(ProjectEntity projectEntity) {
        if(projectRepository.findByProjectName(projectEntity.getProjectName()).size()==0){
            projectRepository.save(projectEntity);
            return true;
        }else {
            System.out.println("Loi khi tao project moi");
            return false;
        }
    }

    @Override
    public boolean deletedProject(int projectId, int userId) {
        if(projectRepository.findById(projectId).getProjectManager().getId()==userId){ //tim kiem project trong db sau do so sanh managerId va userId
            projectRepository.deleteById(projectId);
            return true;
        }else {
            System.out.println("Loi khi xoa project");
            return false;
        }
    }

    @Override
    public boolean updateProject(ProjectEntity project, int userId) {
        if(userId != project.getProjectManager().getId()){
            return false;
        }else {
            if (projectRepository.existsById(project.getId())) {
                projectRepository.save(project);
                return true;
            } else {
                System.out.println("Loi thay doi project");
                return false;
            }
        }
    }

    @Override
    public List<ProjectDTO> searchProjectByName(String projectName) {
        List<ProjectEntity> list = projectRepository.searchProject(projectName);
        List<ProjectDTO> listProject = new ArrayList<>();
        for (ProjectEntity prj : list) {
            ProjectDTO temp = new ProjectDTO();
            temp.setId(prj.getId());
            temp.setProjectAvatar(prj.getProjectAvatar());
            temp.setProjectType(prj.getProjectTypeEntity().getProjectTypeName());
            temp.setProjectName(prj.getProjectName());
            temp.setProjectManagerName(prj.getProjectName());
            listProject.add(temp);
        }
        return listProject;
    }
}
