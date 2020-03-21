package com.timsource.repository;

import com.timsource.model.ProductSale;
import com.timsource.model.ProductSalePK;
import org.springframework.data.repository.CrudRepository;

public interface ProductSaleRepository extends CrudRepository<ProductSale, ProductSalePK> {


}
