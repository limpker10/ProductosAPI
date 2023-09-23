package pe.edu.tecsup.productosapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import pe.edu.tecsup.productosapi.entities.*;

public interface ProductoRespository extends CrudRepository<Producto, Long>{

	@Override
	List<Producto> findAll();
}
