package com.clouddevmind.Tasksproject.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    //Auto generated value for class identity
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

//    @OneToOne
//    @JoinColumn(name = "role_id")
//    private String project_role_id;
    private String user_name;
    private String email;
    private String password;

    /**
     * Auto generated Getter and Setters
     */
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
//    public String getProjectRoleId() {
//        return project_role_id;
//    }
//    public void setProjectRoleId(String project_role_id) {
//        this.project_role_id = project_role_id;
//    }
    /**
     *Auto Generated ToString method
     */
    @Override
    public String toString() {
        return "User [id=" + id + ", user_name=" + user_name + ", email=" + email + ", password=" + password + "]";
    }
}
