package com.dangdat.ecommerce.login;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "role")
public class Role {
    @Id
    private String id;
    private String name;
    private int status;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
