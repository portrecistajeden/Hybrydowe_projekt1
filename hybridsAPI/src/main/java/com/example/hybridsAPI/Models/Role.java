package com.example.hybridsAPI.Models;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "role")
@EntityListeners(AuditingEntityListener.class)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int idRole;

    @Column(name = "role", nullable = false)
    private String role;

    public Role(int idRole, String role){
        this.idRole=idRole;
        this.role=role;
    }
    public Role(){
        super();
    }

    public int getIdRole() {
        return idRole;
    }

    public String getRole() {
        return role;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
