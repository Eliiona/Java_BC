package com.codeassist.CodeAssist.Model;

import java.util.Collection;

import javax.persistence.*;


@Entity
@Table(name = "RoleTable")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Id_role")
    private Long id;
    
    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "role")
    private Collection<User> user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<User> getUser() {
        return user;
    }

    public void setUser(Collection<User> user) {
        this.user = user;
    }
}
