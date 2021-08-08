package elias.spring.boot.crud.crudOperation.repository;

import elias.spring.boot.crud.crudOperation.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    Product findByName(String name);
}
