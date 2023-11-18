package TTTN.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "project_type")
public class ProjectTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "project_type_name")
    private String projectTypeName;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "projectTypeEntity", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "project-projectType")
    private Set<ProjectEntity> projectEntities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectTypeName() {
        return projectTypeName;
    }

    public void setProjectTypeName(String projectTypeName) {
        this.projectTypeName = projectTypeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ProjectEntity> getProjectEntities() {
        return projectEntities;
    }

    public void setProjectEntities(Set<ProjectEntity> projectEntities) {
        this.projectEntities = projectEntities;
    }
}
