package com.mindtree.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.mindtree.daoImpl.SchemeDaoImpl;
import com.mindtree.entity.Scheme;
import com.mindtree.exceptions.dao.AppDaoException;
import com.mindtree.exceptions.service.AppServiceException;
import com.mindtree.service.SchemeService;

@Component
public class SchemeServiceImpl implements SchemeService {

	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	SchemeDaoImpl es = context.getBean("d",SchemeDaoImpl.class);
	
	public String addScheme(Scheme s) throws AppServiceException{
		try {
			es.addScheme(s);
			return "Added";
		} catch (AppDaoException e) {
			throw new AppServiceException("Couln't service", e);
		}
	}

	public Scheme getSchemeById(int id) throws AppServiceException {
		try {
			return es.getSchemeById(id);
		} catch (AppDaoException e) {
			throw new AppServiceException("Error in service", e);
		}
	}
	

	public float SchemeValue(int id, int maturity, int amount) throws AppServiceException {

		Scheme s = new Scheme();
		s = getSchemeById(id);
		float rate = 0f;
		rate = s.getRoi();
		System.out.println(rate);
		System.out.println(maturity);
		System.out.println(amount);
		float calculate = 0f;
		float a = 1+(rate/100);
		calculate = (float) Math.pow(a, maturity);
		float finalVal = 0f;
		finalVal= calculate * amount;
		return finalVal ;
	}
	
	
	
	
	
	
	
	
	public String updateScheme(int id) {
		return null;
	}

	public List<Scheme> getAllSchemes() throws AppServiceException{
		List<Scheme> ls = new ArrayList<Scheme>();
		try {
			ls = es.getAllSchemes();
			return ls;
		}
		catch(AppDaoException e)
		{
			throw new AppServiceException("Unable to service", e);
		}
	}

	public String deleteScheme(int id) {
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	List<Scheme> bubbleSort(List<Scheme> ls) 
//    { 
//		List<Scheme> ls2 = new ArrayList<Scheme>();
//        int n = ls.size(); 
//        for (int i = 0; i < n-1; i++) 
//            for (int j = 0; j < n-i-1; j++) 
//                if (ls.get(j).getRoi() > ls.get(j+1).getRoi()) 
//                {  
//                	Scheme tmp = ls.get(j);
//                	ls.add(j, ls.get(j+1));
//                	ls.add(j+1, tmp);
//                } 
//        return ls;
//    } 

}

