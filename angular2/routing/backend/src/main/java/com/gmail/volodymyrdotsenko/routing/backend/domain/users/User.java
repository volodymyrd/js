package com.gmail.volodymyrdotsenko.routing.backend.domain.users;

import com.gmail.volodymyrdotsenko.routing.backend.domain.BaseEntity;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Volodymyr Dotsenko on 11/27/16.
 */
@Entity
@Table(name = "USR_USERS")
public class User extends BaseEntity {

    public enum EStatus {
        NEW, REGISTERED, DELETED
    }

    private static final long serialVersionUID = 1L;


    public User() {
    }

    public User(String email, String password) {
        this(email, email, password);
    }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    @Size(min = 5, max = 50)
    @Column(name = "USER_NAME", nullable = false, unique = true, length = 255)
    private String userName;

    @NotBlank
    @Email
    @Column(name = "EMAIL", nullable = false, unique = true, length = 255)
    private String email;

    @NotBlank
    @Column(name = "PASSWORD", nullable = false, length = 255)
    private String password;

    @Column(name = "FIRST_NAME", length = 255)
    private String firstName;

    @Column(name = "LAST_NAME", length = 255)
    private String lastName;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Column(name = "EXPIRED")
    private Date expired = new GregorianCalendar(9999, 11, 31).getTime();

    @Column(name = "PHONE", length = 15)
    private String phone;

    @Column(name = "LOCKED")
    private Boolean locked = false;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    @Column(name = "LAST_VISIT")
    private Date lastVisit = new Date();

    @NotNull
    @Column(name = "AGREED_WITH_TAC")
    private Boolean agreedWithTac = true;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private EStatus status = EStatus.NEW;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USR_USERS_ROLES", joinColumns = @JoinColumn(name = "REF_USER_ID"), inverseJoinColumns = @JoinColumn(name = "REF_ROLE_ID"))
    private Set<UserRole> roles = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserProfile> profiles = new HashSet<>();

    @Transient
    private String newPassword;

    @Transient
    private String confirmPassword;

    @Transient
    private String token;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public Boolean getAgreedWithTac() {
        return agreedWithTac;
    }

    public void setAgreedWithTac(Boolean agreedWithTac) {
        this.agreedWithTac = agreedWithTac;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Set<UserProfile> getProfiles() {
        return profiles;
    }

    public void setProfiles(Set<UserProfile> profiles) {
        this.profiles = profiles;
    }
}