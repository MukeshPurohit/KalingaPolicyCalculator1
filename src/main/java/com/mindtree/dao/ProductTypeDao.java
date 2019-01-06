package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.ProductType;
import com.mindtree.exceptions.dao.AppDaoException;

public interface ProductTypeDao {

	List<ProductType> getAllProducts() throws AppDaoException;
}
