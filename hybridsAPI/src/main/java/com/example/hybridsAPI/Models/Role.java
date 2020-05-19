package com.example.hybridsAPI.Models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "role")
@EntityListeners(AuditingEntityListener.class)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer idRole;

    @Column(name = "role", nullable = false)
    private String role;

    public Role(Integer idRole, String role){
        this.idRole=idRole;
        this.role=role;
    }
    public Role(){
        super();
    }

    public Integer getIdRole() {
        return idRole;
    }

    public String getRole() {
        return role;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
