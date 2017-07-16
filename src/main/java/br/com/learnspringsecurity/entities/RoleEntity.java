package br.com.learnspringsecurity.entities;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity(name = "role")
public class RoleEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String module;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public RoleEntity() {
    }

    public RoleEntity(String module) {
        this.module = module;
    }

    @Override
    public String getAuthority() {
        return module;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
