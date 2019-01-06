package com.mindtree.serviceImpl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.mindtree.daoImpl.BankDaoImpl;
import com.mindtree.entity.Bank;
import com.mindtree.exceptions.dao.AppDaoException;
import com.mindtree.exceptions.service.AppServiceException;
import com.mindtree.service.BankService;

@Component
public class BankServiceImpl implements BankService {

	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	BankDaoImpl es = context.getBean("e",BankDaoImpl.class);
	
	public List<Bank> getAllBank() throws AppServiceException {
		try {
		return es.getAllBank();
		}
		catch(AppDaoException err)
		{
			throw new AppServiceException("Couldn't service bank details ",err);
		}
	}

	
}
