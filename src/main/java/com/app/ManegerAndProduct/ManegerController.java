package com.app.ManegerAndProduct;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ManegerController {

    private final ProductService  productService;

@Autowired
private ProductRepository productRepository;
ProductDb productDb=new ProductDb();
@Autowired

    public ManegerController(ProductService productService, CatagroisRepositary catagroisRepositary) {
        this.productService = productService;
    this.catagroisRepositary = catagroisRepositary;
}


    @PostMapping("/add-product")
    public boolean addProduct(ProductInfo productInfo) {

String isAdd =productService.SaveProduct(productInfo);


           /*
           احططططططططططططططططططط يطلع pop uppppppp
            */

        return true;


    }
    private final CatagroisRepositary catagroisRepositary;



    @GetMapping("/all")
    public List<Catagroies> getAllProducts() {
        return catagroisRepositary.findAll();
    }

}
