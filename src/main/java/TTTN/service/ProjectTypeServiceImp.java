package TTTN.service;

import TTTN.dto.ProjectDTO;
import TTTN.dto.ProjectTypeDTO;
import TTTN.entity.ProjectEntity;
import TTTN.entity.ProjectTypeEntity;
import TTTN.repository.ProjectTypeRepository;
import TTTN.service.imp.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectTypeServiceImp implements ProjectTypeService {
    @Autowired
    ProjectTypeRepository projectTypeRepository;

    @Override
    public ProjectTypeEntity projectTypeData(int prjTypeId) {
        return projectTypeRepository.getById(prjTypeId);
    }

    @Override
    public List<ProjectTypeDTO> getAllProjectType() {
        List<ProjectTypeEntity> listPrjTypeEnti = projectTypeRepository.findAll();
        List<ProjectTypeDTO> listPrjType = new ArrayList<>();
        for (ProjectTypeEntity ptype : listPrjTypeEnti) {
            ProjectTypeDTO temp = new ProjectTypeDTO();
            temp.setId(ptype.getId());
            temp.setDescription(ptype.getDescription());
            temp.setProjectTypeName(ptype.getProjectTypeName());
            listPrjType.add(temp);
        }
        return listPrjType;
    }
}
