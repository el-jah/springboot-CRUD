package elias.spring.boot.crud.crudOperation.controller;

import elias.spring.boot.crud.crudOperation.model.Product;
import elias.spring.boot.crud.crudOperation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //Post
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product)//the Request body means the jSON parse in to product object
    {
        return productService.saveProduct(product);

    }
    @PostMapping("/addProducts")
    public List<Product> addProduct(@RequestBody List<Product> product)//the Request body means the jSON parse in to product object
    {
        return productService.saveProducts(product);

    }

    //Get
    @GetMapping("/getProducts")
    public List<Product> getProduct()
    {
        return productService.getProduct();
    }
    @GetMapping("/getProducts/{id}")
    public Product getProductById(@PathVariable int id)
    {
        return productService.getProductById(id);
    }
    @GetMapping("/getProducts/{name}")
    public Product getProductByName(@PathVariable String name)
    {
        return productService.getProductByName(name);
    }


    //put
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product)//the Request body means the jSON parse in to product object
    {
        return productService.updateProduct(product);

    }



    //Delete
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id)
    {
        productService.deleteProduct(id);
        return "product deleted "+id;

    }

}
