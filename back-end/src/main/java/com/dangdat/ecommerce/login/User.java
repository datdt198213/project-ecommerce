package com.dangdat.ecommerce.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
@NoArgsConstructor
public class User {
    @Id
    private int id;
    private String username;
    private String password;
    private String phone;
    private String fullName;
    private String address;
    private String avatar;
    private Date birthday;
    private String email;
    private Date createdAt;
    private Date modifiedAt;
    private int enable;

    @ManyToMany
    @JoinTable(name = "user_role",
            joinColumns =  @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

}
