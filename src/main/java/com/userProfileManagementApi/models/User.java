package com.userProfileManagementApi.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.userProfileManagementApi.anotations.Password;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String userId;
    @NotEmpty(message = "First Name is Required")
    private String firstName;
    @NotEmpty(message = "Last Name is Required")
    private String lastName;
    @NotEmpty(message = "Username is Required")
    private String username;
    @Password
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @Email(message = "Invalid Email Address",regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;
    private String phone;
    @NotEmpty(message = "Gender is Required")
    private String gender;
    private String profileImageUrl;
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;
    private String role;
    private String[] authorities;
    private boolean isActive;
    private boolean isNotLocked;

    public User(){}

    public User(Long id, String userId, String firstName, String lastName, String username,String password, String email, String phone, String gender, String profileImageUrl, Date lastLoginDate, Date lastLoginDateDisplay, Date joinDate, String role, String[] authorities, boolean isActive, boolean isNotLocked) {
        this.id = id;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.gender = gender;
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.profileImageUrl = profileImageUrl;
        this.lastLoginDate = lastLoginDate;
        this.lastLoginDateDisplay = lastLoginDateDisplay;
        this.joinDate = joinDate;
        this.role = role;
        this.authorities = authorities;
        this.isActive = isActive;
        this.isNotLocked = isNotLocked;
    }


}
