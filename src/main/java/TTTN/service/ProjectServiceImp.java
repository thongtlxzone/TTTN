package TTTN.service;

import TTTN.entity.ProjectEntity;
import TTTN.repository.ProjectRepository;
import TTTN.service.imp.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImp implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;
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
}
