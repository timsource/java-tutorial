package com.timsource;

import com.timsource.model.Product;
import com.timsource.model.ProductSale;
import com.timsource.model.ProductSalePK;
import com.timsource.model.Sale;
import com.timsource.repository.ProductRepository;
import com.timsource.repository.ProductSaleRepository;
import com.timsource.repository.SaleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationCommandLine implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ApplicationCommandLine.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductSaleRepository productSaleRepository;

    public static void main(String[] args) {
        SpringApplication.run(ApplicationCommandLine.class, args);
    }

    @Override
    public void run(String... args) {

        Product rice = productRepository.save(new Product("Rice", 1.5D));
        Sale sale = saleRepository.save(new Sale("BF"));

        ProductSalePK productSalePK = new ProductSalePK(rice.getProductId(), sale.getSaleId());
        ProductSale productSale = new ProductSale();
        productSale.setId(productSalePK);
        productSale.setQuantity(5);
        productSaleRepository.save(productSale);

        ProductSale productSaleRice = productSaleRepository.findById(productSalePK).get();
        log.info("sale={}", productSaleRice.getSale());
        log.info("product={}", productSaleRice.getProduct());

    }

}
