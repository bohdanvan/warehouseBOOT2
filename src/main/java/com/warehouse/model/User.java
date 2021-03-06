package com.warehouse.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.text.StyleConstants.Size;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Long userId;

    @Size(min=2, max=10 , message = "login min 2 max 6")
    @Column(name = "username")
    private String userName;

    @Size(min=2, max=10 , message = "password min2 max 10")
    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    //	@Column(name ="enabled")
//	private int enabled;	
    @Column(name = "enabled") // FIXME: 14.11.2016
    private boolean enabled;

    @OneToMany(mappedBy = "userJOIN", cascade = CascadeType.ALL, orphanRemoval = true)
    public List<UserRole> userRolesList = new ArrayList<>();

//    @OneToOne
//    public UserFullInfo userFullInfo;

    public void addRole(String role) { // FIXME: 16.11.2016

        userRolesList.add(new UserRole(this, role));
    }

    public User() {

    }

    public User(User user) {
        this.userId = user.userId;
        this.userName = user.userName;
        this.email = user.email;
        this.password = user.password;
        this.enabled = user.enabled;
    }

//    public UserFullInfo getUserFullInfo() {
//        return userFullInfo;
//    }
//
//    public void setUserFullInfo(UserFullInfo userFullInfo) {
//        this.userFullInfo = userFullInfo;
//    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Long getUserid() {
        return userId;
    }

    public void setUserid(Long userid) {
        this.userId = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<UserRole> getUserRolesList() {
        return userRolesList;
    }

    public void setUserRolesList(List<UserRole> userRolesList) {
        this.userRolesList = userRolesList;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", userRolesList=" + userRolesList +
                '}';
    }
}