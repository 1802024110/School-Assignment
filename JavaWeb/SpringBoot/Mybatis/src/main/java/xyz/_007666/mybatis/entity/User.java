package xyz._007666.mybatis.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private long id;
    private String username;
    private String password;
    private String gender;
    private String phone;
    private List<Comment> comments;
    private Address address;
}
