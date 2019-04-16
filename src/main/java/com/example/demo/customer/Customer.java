package com.example.demo.customer;

import com.example.demo.book.BookEntity;
import com.example.demo.borrow.BorrowEntity;

import java.util.List;

public class Customer {

    private Integer id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String sex;
    private Integer age;
    private String city;
    private String street;
    private String homeNr;
    private String postalCode;
    private Float salary;
    private String role;
    private boolean isPublic;
    private Integer mark;
    private String review;
    private String title;
    private String type;
    private List<BookEntity> list;

    public Customer() {
    }

    public Customer(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Customer(String email, String password, String name, String surname, String sex) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
    }

    public Customer(Integer id, String email, String password, String name, String surname, String sex, Integer age, String city, String street, String homeNr, String postalCode, Float salary, String role, boolean isPublic) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        this.city = city;
        this.street = street;
        this.homeNr = homeNr;
        this.postalCode = postalCode;
        this.salary = salary;
        this.role = role;
        this.isPublic = isPublic;
    }

    public Customer(Integer id, String email, String password, String name, String surname, String sex, Integer age, String city, String street, String homeNr, String postalCode, Float salary, String role, boolean isPublic, Integer mark, String review, String title, String type, List<BookEntity> list) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        this.city = city;
        this.street = street;
        this.homeNr = homeNr;
        this.postalCode = postalCode;
        this.salary = salary;
        this.role = role;
        this.isPublic = isPublic;
        this.mark = mark;
        this.review = review;
        this.title = title;
        this.type = type;
        this.list = list;
    }

    public Customer(String name, String surname, List<BookEntity> list) {
        this.name = name;
        this.surname = surname;
        this.list = list;
    }

    public Customer(Integer id, Float salary) {
        this.id = id;
        this.salary = salary;
    }

    public Customer(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeNr() {
        return homeNr;
    }

    public void setHomeNr(String homeNr) {
        this.homeNr = homeNr;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<BookEntity> getList() {
        return list;
    }

    public void setList(List<BookEntity> list) {
        this.list = list;
    }
}
