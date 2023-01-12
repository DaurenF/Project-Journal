package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "users")
@ToString
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class User implements UserDetails {
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    @NotEmpty(message = "Fill your name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "birth")
    private Date birth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "country")
    private String country;

    @Column(name = "email")
    @Email(message = "Enter correct email")
    @NotEmpty(message = "Fill your email")
    private String email;
    @Column(name = "password")
    @NotEmpty(message = "Fill your password")
    private String password;

    @Column(name = "exp_date")
    private Date exp_date;

    public User(String name, String surname, Date birth, String gender, String country, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.gender = gender;
        this.country = country;
        this.email = email;
        this.password = password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
