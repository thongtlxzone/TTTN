package TTTN.service;

import TTTN.dto.ProjectDTO;
import TTTN.dto.TaskDTO;
import TTTN.entity.ProjectEntity;
import TTTN.entity.TaskEntity;
import TTTN.payload.ClassifyProjectTasks;
import TTTN.repository.ProjectRepository;
import TTTN.service.imp.ProjectNUserService;
import TTTN.service.imp.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImp implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    ProjectNUserService projectNUserService;
    @Override
    public ProjectDTO showProject(int projectId) {
        ProjectEntity project = projectRepository.findById(projectId);
        ProjectDTO showPrj = new ProjectDTO();
        showPrj.setId(project.getId());
        showPrj.setProjectName(project.getProjectName());
        showPrj.setProjectAvatar(project.getProjectAvatar());
        showPrj.setProjectType(project.getProjectTypeEntity().getProjectTypeName());
        showPrj.setProjectManagerName(project.getProjectManager().getFullname());
        showPrj.setUserCreatedName(project.getUserCreated());
        return showPrj;
    }

    @Override
    public boolean createProject(ProjectEntity projectEntity, int userId) {
        if(projectRepository.findByProjectName(projectEntity.getProjectName()).size()==0){
            projectRepository.save(projectEntity);
            ProjectEntity project = projectRepository.findByProjectName(projectEntity.getProjectName()).get(-1);
            projectNUserService.createNewProjectNUser(userId,project.getId());
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
        ProjectEntity projectChanged = projectRepository.findById(project.getId());
        if(userId != projectChanged.getProjectManager().getId()){
            System.out.println("Loi quyen han");
            return false;
        }else {
            if (projectRepository.existsById(project.getId())) {
                projectChanged.setId(project.getId());
                projectChanged.setProjectAvatar(project.getProjectAvatar());
                projectChanged.setProjectManager(project.getProjectManager());
                projectChanged.setProjectName(project.getProjectName());
                projectChanged.setProjectTypeEntity(project.getProjectTypeEntity());
                projectRepository.save(projectChanged);
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
            temp.setUserCreatedName(prj.getUserCreated());
            listProject.add(temp);
        }
        return listProject;
    }

    @Override
    public ClassifyProjectTasks showListTask(int projectId) {
        ClassifyProjectTasks projectTasks = new ClassifyProjectTasks();
        ProjectEntity thisProject = projectRepository.findById(projectId);
        for (TaskEntity task: thisProject.getTaskEntities()) {
            TaskDTO taskDTO = new TaskDTO();
            if(task.isTaskDone()==true){
                taskDTO.setId(task.getId());
                taskDTO.setTaskName(task.getTaskName());
                taskDTO.setDescription(task.getDescription());
                taskDTO.setManagerName(task.getManager().getFullname());
                taskDTO.setReporter(task.getReporter().getFullname());
                taskDTO.setTasktype(task.getTaskTypeEntity().getTaskTypeName());
                taskDTO.setCategory(task.getCategory());
                taskDTO.setTaskStatus(task.isTaskDone());
                taskDTO.setDateCreated(task.getDateCreated());
                projectTasks.getDoneList().add(taskDTO);
            }else {
                taskDTO.setId(task.getId());
                taskDTO.setTaskName(task.getTaskName());
                taskDTO.setDescription(task.getDescription());
                taskDTO.setManagerName(task.getManager().getFullname());
                taskDTO.setReporter(task.getReporter().getFullname());
                taskDTO.setTasktype(task.getTaskTypeEntity().getTaskTypeName());
                taskDTO.setCategory(task.getCategory());
                taskDTO.setDeadline(task.getDeadline());
                taskDTO.setTaskStatus(task.isTaskDone());
                projectTasks.getToDoList().add(taskDTO);
            }
        }
        return projectTasks;
    }
}
