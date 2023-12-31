package com.app.maneger_and_product;

import com.app.customer.CustomerDb;
import com.app.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service

public class ProductService {
    Logger logger = Logger.getLogger(getClass().getName());
    CardDb cardDb=new CardDb();
    private final CatagroisRepositary catagroisRepositary;
    private final CustomerRepository customerRepository;
    private final CardRepository cardRepository;
    private final ProductRepository productRepository;
    ProductDb productDb;

    Catagroies catagroies;
    @Autowired
    public ProductService(CatagroisRepositary catagroisRepositary , CustomerRepository customerRepository , CardRepository cardRepository
    , ProductRepository productRepository){
        this.catagroisRepositary=catagroisRepositary;
        this.customerRepository=customerRepository;
        this.cardRepository=cardRepository;
        this.productRepository=productRepository;
    }
    public String saveProduct(ProductInfo productInfo, ProductDb productDb) {


        Catagroies catagroies1= this.catagroisRepositary.findByName(productInfo.getSection());
        boolean exist = productRepository.existsById(productInfo.getProductId());
        if (!exist) {

            productDb.setProId(productInfo.getProductId());
            productDb.setProName(productInfo.getProductName());
            productDb.setProPrice(productInfo.getPrice());
            productDb.setProductSection(productInfo.getSection());
            productDb.setNumberOfProducts(productInfo.getNumberOf());
            productDb.setProductImage(productInfo.getImage());
            productDb.setInfo(productInfo.getInformation());
            productDb.setCategories(catagroies1);

            return "Product added successfully";
        }
        else
            return "Product already exist!";
    }


    public List<String> getAllCategories() {
        return catagroisRepositary.findDistinctCategories();
    }


    public String saveCatagroies(CatagroiesForm catagroiesForm) {


        boolean exist = catagroisRepositary.existsById( catagroiesForm.getCataId());
        logger.info("Existence: " + exist);
        boolean nameExist= catagroisRepositary.existsByName(catagroiesForm.getCataName());

        if(exist){
            return "Category already exists";
        }

        else if(nameExist){
            return "Category Name already exists";
        }

       else {
            logger.info("llll");
            catagroies=new Catagroies();
            catagroies.setId(catagroiesForm.getCataId());
            catagroies.setName(catagroiesForm.getCataName());
            catagroies.setImageUrl(catagroiesForm.getImage());
            catagroies.setCategory(catagroiesForm.getCataName());
            catagroisRepositary.save(catagroies);
            return "Category added successfully";
        }

}



public String addToCart(int productId,int userId) {

    Optional<ProductDb> productOptional = productRepository.findById(productId);
    List<CardDb> order = cardRepository.findByCustomerDbId(userId);
    int totalPrice = 0;
    for (CardDb card : order) {
        totalPrice += card.getTotalPrice();
    }

    if (productOptional.isPresent()) {
        ProductDb product = productOptional.get();
        totalPrice += product.getProPrice();
        if (totalPrice <= 1000) {
            int number = product.getNumberOfProducts();
            if (number == 0) {
                return "the product not available for now";
            }
            number -= 1;
            product.setNumberOfProducts(number);
            if (number == 0) {
                product.setProductIsAvailable("false");
            }

            productRepository.save(product);
            Optional<CustomerDb> customerDbOptional = customerRepository.findById(userId);
            if(customerDbOptional.isPresent()) {
                CustomerDb customer = customerDbOptional.get();
                CardDb cartItem = new CardDb();
                cartItem.setProductDb(product);
                cartItem.setCustomerDb(customer);
                cartItem.setTotalPrice(product.getProPrice());
                cartItem.setCardId(2);

                cardRepository.save(cartItem);
                return "product is added successfully";
            }

        }

        return "The Cart is full";

}
    return "the product not available for now ";}


    public List<ProductDb> getProductsByUserId(int userId) {
        List<CardDb> cards = cardRepository.findByCustomerDbId(userId);
        List<ProductDb> products = new ArrayList<>();

        for (CardDb card : cards) {
            products.add(card.getProductDb());
        }

        return products;
    }

    public String deleteproduct(int productId){

        Optional<ProductDb> productDb1= productRepository.findById(productId);
        if(productDb1.isPresent()) {
            ProductDb productDb2 = productDb1.get();
            productRepository.deleteAllById(Collections.singleton(productDb2.getProId()));
        }
    return "delete successfully";



}



    public String updateProduct(int id, ProductInfo productInfo){
        Catagroies catagroies1= catagroisRepositary.findByName(productInfo.getSection());

        Optional<ProductDb> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()) {
            ProductDb product = optionalProduct.get();
            product.setProId(productInfo.getProductId());
            product.setProName(productInfo.getProductName());
            product.setProPrice(productInfo.getPrice());
            product.setProductSection(productInfo.getSection());
            product.setNumberOfProducts(productInfo.getNumberOf());
            product.setProductImage(productInfo.getImage());
            product.setInfo(productInfo.getInformation());
            product.setCategories(catagroies1);
            productRepository.save(product);
        }
        return "hi ";
    }

    public void deleteCategories(String id) {
       Catagroies deleteCatagory= catagroisRepositary.findByName(id);
        catagroisRepositary.deleteAllById(Collections.singleton(deleteCatagory.getId()));


    }
}