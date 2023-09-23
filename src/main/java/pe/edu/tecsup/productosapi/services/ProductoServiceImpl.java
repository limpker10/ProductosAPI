package pe.edu.tecsup.productosapi.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.tecsup.productosapi.entities.Producto;
import pe.edu.tecsup.productosapi.repositories.ProductoRespository;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRespository productRespository;

	@Override
	public List<Producto> findAll() {
		// TODO Auto-generated method stub
		return productRespository.findAll();
	}

	@Override
	public Producto findById(Long id) {
		// TODO Auto-generated method stub
		return productRespository.findById(id).orElseThrow(()-> new EntityNotFoundException("No existe registro"));
	}

	@Override
	public void save(Producto producto) {
		// TODO Auto-generated method stub
		productRespository.save(producto);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		productRespository.deleteById(id);
	}
	
	

}
