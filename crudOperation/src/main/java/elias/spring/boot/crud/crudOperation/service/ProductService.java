package elias.spring.boot.crud.crudOperation.service;


import elias.spring.boot.crud.crudOperation.model.Product;
import elias.spring.boot.crud.crudOperation.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //post
    public Product saveProduct(Product product)
    {
      return productRepository.save(product);
    }
    //post
    public List<Product> saveProducts(List<Product> product)
    {
        return productRepository.saveAll(product);
    }

    //get
    public List<Product> getProduct()
    {
        return productRepository.findAll();
    }
    //get by id
    public Product getProductById(int id)
    {
        return productRepository.findById(id).orElse(null);
    }
    //get by name
    public Product getProductByName(String name)
    {
        return productRepository.findByName(name);
    }

    //delete
    public String deleteProduct(int id)
    {
        productRepository.deleteById(id);
        return "product removed !! "+id;
    }
    //update
    public Product updateProduct(Product product)
    {
        Product existingProuct=productRepository.findById(product.getId()).orElse(null);
        existingProuct.setName(product.getName());
        existingProuct.setPrice(product.getPrice());
        existingProuct.setQuantity(product.getQuantity());
        return productRepository.save(existingProuct);


    }

}
