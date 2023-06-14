package com.workshop.SecurityGabo.service.implementation;

import com.workshop.SecurityGabo.dao.UserDao;
import com.workshop.SecurityGabo.dto.AuthenticationRequest;
import com.workshop.SecurityGabo.service.UsuariosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class UsuariosServiceImplementation implements UsuariosService{

    private final UserDao userDao;

    public UsuariosServiceImplementation(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public List<AuthenticationRequest> getAllUsuarios(){
        List<AuthenticationRequest> allUsuarios = null;
        try{
            log.info("Empezando el getAllUsuarios");
            allUsuarios = userDao.findAll();
            if(allUsuarios.isEmpty()){
                log.error("No se encontro ningun jugador");
                return null;
            }
            log.info("Terminando getAllUsuario");
            return allUsuarios;
        }
        catch(Exception exception){
            log.error(exception.getMessage());
        }
        return allUsuarios;
    }

    @Override
    public AuthenticationRequest getUsuariosById(Integer id){
        AuthenticationRequest particularUsuarios = null;
        try {
            log.info("Empezando el getUsuariosById");
            particularUsuarios = userDao.getReferenceById(id);
            if (particularUsuarios.getEmail() == null) {
                log.error("No se encontro ningun usuario con ese ID");
                return null;
            }
            log.error("Terminando getUsuariosById");
            return particularUsuarios;
        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return particularUsuarios;
    }

    @Override
    public AuthenticationRequest createUsuario(AuthenticationRequest authenticationRequest){
        AuthenticationRequest createUsuario = null;
        try{
            log.info("Empezando el createUsuarios");
            if(!StringUtils.hasText(authenticationRequest.getEmail())){
                return null;
            }
            createUsuario = userDao.save(authenticationRequest);
            log.info("Terminando createUsuarios");
        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return createUsuario;
    }

    @Override
    public AuthenticationRequest updateUsuario(AuthenticationRequest authenticationRequest){
        AuthenticationRequest updateUsuarios = null;
        try{
            log.info("Empezando el updateUsuarios");
            if(!StringUtils.hasText(authenticationRequest.getEmail()) || authenticationRequest.getPassword() == null){
                log.error("Falto algun dato");
                return null;
            }
            updateUsuarios = userDao.save(authenticationRequest);
            log.info("Terminado el updateUsuarios");

        }catch (Exception exception){
            log.error(exception.getMessage());
        }
        return updateUsuarios;
    }

    @Override
    public void deleteUsuarioById(Integer id){
        log.info("Empeznado el deleteUsuarioById");
        userDao.deleteById(id);
        log.info("Finalizado el deleteById");
    }



}
