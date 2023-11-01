package com.team2.flea_market.entity;

import com.team2.flea_market.dto.user.Role;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"ads", "comments"})
@EqualsAndHashCode(exclude = {"ads", "comments"})
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "user")
    private List<Ad> ads;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

}
