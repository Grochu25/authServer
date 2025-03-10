package com.grochu.authserver.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class User implements UserDetails
{
    private String email;
    @JsonIgnore
    private String password;
    private String role;

    public User(){
        email = "";
        password = "";
        role = "";
    }

    public User(String email, String password, String role){
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        switch (role.toLowerCase())
        {
            case "admin":
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            case "user":
                authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                break;
        }
        return authorities;
    }

    @Override
    public String getUsername() {
        return email;
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
