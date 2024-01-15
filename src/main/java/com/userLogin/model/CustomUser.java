package com.userLogin.model;

public class CustomUser {

    private Long id;

    private String username;

    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String address;

    private int active;

    private String roles = "";

    private String permissions = "";

    public CustomUser(Long id, String username, String password, String firstname, String lastname, String email, String phone, String address, String roles, String permissions) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.active = 1;
        this.roles = roles;
        this.permissions = permissions;
    }

    protected CustomUser(){}

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getActive() {
        return active;
    }

    public String getRoles() {
        return roles;
    }

    public String getPermissions() {
        return permissions;
    }
}