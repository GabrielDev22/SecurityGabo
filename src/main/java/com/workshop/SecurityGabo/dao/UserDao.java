package com.workshop.SecurityGabo.dao;

import com.workshop.SecurityGabo.dto.AuthenticationRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<AuthenticationRequest, Integer> {

    /* static final List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User(
                    "gabrieltorresmora2@gmail.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE ADMIN"))
            ),
            new User(
                    "user.mail@gmail.com",
                    "password",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE USER"))
            )
    ); */

    public static UserDetails findUserByEmail(String email) {
        return APPLICATION_USERS
                .stream()
                .filter(u -> u.getUsername().equals(email))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user was found"))
                ;
    }


}
