package com.mindtree.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mindtree.dao.ProductTypeDao;
import com.mindtree.entity.ProductType;
import com.mindtree.exceptions.dao.AppDaoException;

@Repository
public class ProductTypeDaoImpl implements ProductTypeDao{
	
	HibernateTemplate ht = new HibernateTemplate();
	
	public HibernateTemplate getTemplate()
	{
		return ht;
	}
	
	public void setTemplate(HibernateTemplate template)
	{
		this.ht = template;
	}
	
	public List<ProductType> getAllProducts() throws AppDaoException{
		
		List<ProductType> lb = new ArrayList<ProductType>();
		try {
			lb = ht.loadAll(ProductType.class);
			return lb;
		}
		catch (Exception err)
		{
			throw new AppDaoException("Error connectiong to db", err);
		}
	}

}
