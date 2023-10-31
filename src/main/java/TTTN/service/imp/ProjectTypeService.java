package TTTN.service.imp;

import TTTN.dto.ProjectDTO;
import TTTN.dto.ProjectTypeDTO;
import TTTN.entity.ProjectTypeEntity;

import java.util.List;

public interface ProjectTypeService {
    ProjectTypeEntity projectTypeData(int prjTypeId);
    List<ProjectTypeDTO> getAllProjectType();
}
