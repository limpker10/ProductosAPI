package pe.edu.tecsup.productosapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.tecsup.productosapi.entities.Usuario;
import pe.edu.tecsup.productosapi.repositories.AuthenticationRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService{
    @Autowired
    private AuthenticationRepository usuarioRepository;
    @Override
    public Usuario findByUsernameAndPassword(String username, String password) {
        return usuarioRepository.findByUsernameAndPassword(username, password);
    }
    @Override
    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username) ;
    }
}
