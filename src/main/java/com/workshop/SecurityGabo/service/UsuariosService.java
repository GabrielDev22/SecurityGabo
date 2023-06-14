package com.workshop.SecurityGabo.service;

import com.workshop.SecurityGabo.dto.AuthenticationRequest;
import java.util.List;
public interface UsuariosService {

    List<AuthenticationRequest> getAllUsuarios();

    AuthenticationRequest getUsuariosById(Integer id);

    AuthenticationRequest createUsuario(AuthenticationRequest authenticationRequest);

    AuthenticationRequest updateUsuario(AuthenticationRequest authenticationRequest);

    void deleteUsuarioById(Integer id);



}
