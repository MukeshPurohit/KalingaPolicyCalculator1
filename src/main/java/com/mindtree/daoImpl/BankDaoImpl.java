package com.mindtree.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mindtree.dao.BankDao;
import com.mindtree.entity.Bank;
import com.mindtree.exceptions.dao.AppDaoException;

@Repository
public class BankDaoImpl implements BankDao {

	HibernateTemplate ht = new HibernateTemplate();
	
	public HibernateTemplate getTemplate()
	{
		return ht;
	}
	
	public void setTemplate(HibernateTemplate template)
	{
		this.ht = template;
	}
	public List<Bank> getAllBank() throws AppDaoException{
		
		List<Bank> lb = new ArrayList<Bank>();
		try 
		{
			lb = ht.loadAll(Bank.class);
			return lb;
		}
		catch(Exception err)
		{
			throw new AppDaoException("Couldn't connect to db", err);
		}
	}

}
