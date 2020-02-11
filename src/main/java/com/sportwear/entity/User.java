package com.sportwear.entity;

import java.util.ArrayList;
import java.util.List;

public class User implements IUser{

    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String phone;
    private Long address_id;
    private UserRole userRole;

    private List<Customer> customerList = new ArrayList<>();

    public User() {
    }

    public User(String first_name, String last_name, String email, String password, String phone,
                Long address_id, UserRole userRole, List<Customer> customerList) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.address_id = address_id;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
        this.customerList = customerList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }



    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public boolean isAdmin() {
        return userRole == UserRole.ROLE_ADMIN;
    }

    public boolean isJustUser() {
        return userRole == UserRole.ROLE_USER;
    }

}
