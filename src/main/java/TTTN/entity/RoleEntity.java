package TTTN.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @OneToMany(mappedBy = "roleEntity", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-role")
    private Set<UsersEntity> usersEntitySet;
    public RoleEntity(){}
    public RoleEntity(int id) {
        this.id = id;
    }

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
}
