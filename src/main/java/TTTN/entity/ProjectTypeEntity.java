package TTTN.entity;

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
    @OneToMany(mappedBy = "projectTypeEntity")
    private Set<ProjectEntity> projectEntities;
}
