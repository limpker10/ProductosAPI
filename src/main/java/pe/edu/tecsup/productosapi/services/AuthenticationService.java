package pe.edu.tecsup.productosapi.services;

import org.springframework.stereotype.Service;
import pe.edu.tecsup.productosapi.entities.Usuario;

@Service
public interface AuthenticationService {
    Usuario findByUsernameAndPassword(String username, String password);
    Usuario findByUsername(String username);
}
