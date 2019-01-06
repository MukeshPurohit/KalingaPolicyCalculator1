package com.mindtree.serviceImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.mindtree.daoImpl.ProductTypeDaoImpl;
import com.mindtree.entity.ProductType;
import com.mindtree.exceptions.dao.AppDaoException;
import com.mindtree.exceptions.service.AppServiceException;
import com.mindtree.service.ProductService;

@Component
public class ProductTypeServiceImpl implements ProductService {

	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	ProductTypeDaoImpl es = context.getBean("f",ProductTypeDaoImpl.class);
	
	public List<ProductType> getAllProducts() throws AppServiceException
	{
			try {
				return es.getAllProducts();
			} catch (AppDaoException e) {
				//System.out.println("Problem get products");
				throw new AppServiceException("couldn't service", e); 
			}
	}
}
		
