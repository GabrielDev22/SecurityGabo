package com.workshop.SecurityGabo.controllers;

import com.workshop.SecurityGabo.dao.UserDao;
import com.workshop.SecurityGabo.config.JwtUtils;
import com.workshop.SecurityGabo.dto.AuthenticationRequest;
import com.workshop.SecurityGabo.service.UsuariosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
public class AutenticationController {

    /* private final AuthenticationManager authenticationManager; */

    private final UsuariosService usuariosService;
    /* private final UserDao userDao; */
     /* private final JwtUtils jwtUtils; */

    public AutenticationController(UsuariosService usuariosService){ this.usuariosService = usuariosService;}


    @GetMapping("/getAll")
    public List<AuthenticationRequest> getAllUsuarios(){
        if(usuariosService.getAllUsuarios() == null){
            return null;
        }
        return usuariosService.getAllUsuarios();
    }

    @GetMapping("/get/{id}")
    public AuthenticationRequest getUsuariosById(@PathVariable Integer id){
        if(usuariosService.getUsuariosById(id) == null){
            return null;
        }
        return usuariosService.getUsuariosById(id);
    }

    @PostMapping("/authenticate")
    public AuthenticationRequest createUsuario(@RequestBody AuthenticationRequest authenticationRequest){
        if(usuariosService.createUsuario(authenticationRequest) == null){
            return null;
        }
        return usuariosService.createUsuario(authenticationRequest);
    }

    @PutMapping("/update")
    public AuthenticationRequest updateUsuario(@RequestBody AuthenticationRequest authenticationRequest){
        if(usuariosService.updateUsuario(authenticationRequest) == null){
            return null;
        }
        return usuariosService.updateUsuario(authenticationRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUsuarioById(@PathVariable Integer id) {usuariosService.deleteUsuarioById(id);}

    /*
     @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        final UserDetails user = userDao.findUserByEmail(request.getEmail());
        if(user != null){
            return ResponseEntity.ok(jwtUtils.generateToken(user));
        }
        return ResponseEntity.status(400).body("Some errro has ocurred");
    }*/
}
