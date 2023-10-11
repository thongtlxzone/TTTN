package TTTN.entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "rolename")
    private String roleName;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "roleEntity")
    private Set<UsersEntity> usersEntitySet;
    @OneToMany(mappedBy = "roleEntity")
    private Set<FuntionOfRolesEntity> funtionOfRolesEntities;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<UsersEntity> getUsersEntitySet() {
        return usersEntitySet;
    }

    public void setUsersEntitySet(Set<UsersEntity> usersEntitySet) {
        this.usersEntitySet = usersEntitySet;
    }

    public Set<FuntionOfRolesEntity> getFuntionOfRolesEntities() {
        return funtionOfRolesEntities;
    }

    public void setFuntionOfRolesEntities(Set<FuntionOfRolesEntity> funtionOfRolesEntities) {
        this.funtionOfRolesEntities = funtionOfRolesEntities;
    }
}
