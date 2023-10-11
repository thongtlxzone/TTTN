package TTTN.entity;

import javax.persistence.*;

@Entity(name = "funtion_of_role")
public class FuntionOfRolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "funtion_name")
    private String funtionName;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;
}
