package com.mindtree.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.entity.Bank;
import com.mindtree.entity.ProductType;
import com.mindtree.entity.Scheme;
import com.mindtree.exceptions.service.AppServiceException;
import com.mindtree.serviceImpl.BankServiceImpl;
import com.mindtree.serviceImpl.ProductTypeServiceImpl;
import com.mindtree.serviceImpl.SchemeServiceImpl;

@RestController
public class HomeController {

	@Autowired
	SchemeServiceImpl sci;
	
	@Autowired
	BankServiceImpl bsi;
	
	@Autowired
	ProductTypeServiceImpl psi;
	
	@RequestMapping(value="/addScheme1")
	public ModelAndView pageAddScheme()
	{
		return new ModelAndView("addScheme");
	}
	
	@RequestMapping(value="/calculate1")
	public ModelAndView SchemeCalculatorPage()
	{
		return new ModelAndView("SchemeCalculator");
	}
	
	@RequestMapping(value="/getData")
	public ModelAndView getScheme()
	{
		try {
			List<Scheme> a = new ArrayList<Scheme>();
			a = sci.getAllSchemes();
			Collections.sort(a);
			return new ModelAndView("SchemeDetails","message",a);
		} catch (AppServiceException e) {
			System.out.println(e.getCause()+" "+e.getMessage());
			return null;
		}
	}
	
	@RequestMapping(value="/calculate", method = RequestMethod.POST)
	public ModelAndView SchemeCalculator(HttpServletRequest req)
	{
		float f;
		boolean check = false;
		String msg = new String();
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			List<Scheme> ls = new ArrayList<Scheme>();
			ls = sci.getAllSchemes();
			for(Scheme scheme : ls)
			{
				if(scheme.getId() == id)
				{
					check = true;
					f = sci.SchemeValue(id, Integer.parseInt(req.getParameter("maturity")), Integer.parseInt(req.getParameter("amountInvested")));
					return new ModelAndView("SchemeCalculator","message",f);
				}
			}
			if(check == false)
			{
				throw new Exception("No scheme under this id");
			}
		}  catch (AppServiceException e1) {
			System.out.println(e1.getMessage()+" "+e1.getCause());
			msg = e1.getMessage();
		}
		catch (Exception e) {
			System.out.println("Problem fetching data");
			msg = e.getMessage();
		}
		return new ModelAndView("index","message",msg);
	}
	
	@RequestMapping(value="addScheme", method = RequestMethod.POST)
	public ModelAndView addScheme(HttpServletRequest req)
	{
		List<Bank> lb = new ArrayList<Bank>();
		List<ProductType> pt = new ArrayList<ProductType>();
		boolean check = false;
		Scheme s = new Scheme();
		Bank b2 = new Bank();
		ProductType pt1 = new ProductType();
		int id = Integer.parseInt(req.getParameter("schemeId"));
		String schemeName = req.getParameter("schemeName");
//		char[] ch = new char[schemeName.length()];
//		int k = 0;
//		ch = schemeName.toCharArray();
//		for(int i=0;i<ch.length;i++)
//		{
//			k = (int) ch[i];
//			if((k >= 90 || k <= 65) && (k>=122 || k<= 97) && (k>=57 || k<=48))
//			{
//				
//			}
//		}
		List<Scheme> ls = new ArrayList<Scheme>();
		try {
			ls = sci.getAllSchemes();
		} catch (AppServiceException e3) {
			return new ModelAndView("index","message",e3.getMessage());
		}
		
		for(Scheme scheme : ls)
		{
			if(scheme.getId() == id || scheme.getName().equals(schemeName))
			{
				check = true;
				try {
					throw new Exception("Cannot add with this id or Scheme Name");
				} catch (Exception e) {
					return new ModelAndView("index", "message",e.getMessage());
				}
			}
		}
		s.setId(id);
		s.setName(schemeName);
		
		
		String b = req.getParameter("bankName");
		
		// Checking for bank availability
		try {
			lb = bsi.getAllBank();
			for(Bank bank : lb)
			{
				if(bank.getName().equals(b))
				{
					check = true;
					for(Bank b1: lb)
					{
						if(b1.getName().equalsIgnoreCase(b))
						{
							b2.setId(b1.getId());
							b2.setName(b1.getName());
						}
					}
					s.setBank(b2);
				}
			}
			if(check == false)
			{
				throw new Exception("Bank not found");
			}
		} catch (AppServiceException e) {
			System.out.println(e.getMessage()+" "+e.getCause());
		}
		catch(Exception e1)
		{
			System.out.println(e1.getMessage()+" "+e1.getCause());
		}
		
		
		// Checking for productType availability
		String p = req.getParameter("schemeType");
		check = false;
		try {
			pt = psi.getAllProducts();
			for(ProductType productType : pt)
			{
				if(productType.getName().equals(p))
				{
					check = true;
					for(ProductType pt2 : pt)
					{
						if(pt2.getName().equalsIgnoreCase(p))
						{
							pt1.setId(pt2.getId());
							pt1.setName(pt2.getName());
						}
					}
				}
			}
			if(check == false)
			{
				throw new Exception("ProductType not found");
			}
			s.setProductType(pt1);
			s.setRoi(Integer.parseInt(req.getParameter("roi")));
			return new ModelAndView("index","message",sci.addScheme(s));
		} catch (AppServiceException e2) {
			System.out.println(e2.getMessage()+" "+e2.getCause());
			return new ModelAndView("index","message","Exception");
		}
		catch(Exception e1)
		{
			System.out.println(e1.getMessage()+" "+e1.getCause());
			return new ModelAndView("index","message","Exception");
		}
		
	}
	
}
