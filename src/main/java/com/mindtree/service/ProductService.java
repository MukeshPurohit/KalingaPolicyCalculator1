package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.ProductType;
import com.mindtree.exceptions.service.AppServiceException;

public interface ProductService {

	List<ProductType> getAllProducts() throws AppServiceException;
}
