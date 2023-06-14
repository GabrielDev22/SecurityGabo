package com.workshop.SecurityGabo.dto;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "usuarios")
public class AuthenticationRequest {

    @Id
    @GeneratedValue
    private String email;

    @Column(name = "password")
    private String password;

}
