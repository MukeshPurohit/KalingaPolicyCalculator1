package com.mindtree.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mindtree.dao.SchemeDao;
import com.mindtree.entity.Scheme;
import com.mindtree.exceptions.dao.AppDaoException;

@Repository
public class SchemeDaoImpl implements SchemeDao {

	HibernateTemplate ht = new HibernateTemplate();
	
	public HibernateTemplate getTemplate()
	{
		return ht;
	}
	
	public void setTemplate(HibernateTemplate template)
	{
		this.ht = template;
	}
	
	public void addScheme(Scheme s1) throws AppDaoException {
		try {
			Session s = ht.getSessionFactory().openSession();
			s.save(s1);
			s.beginTransaction().commit();
		}
		catch(Exception err)
		{
			throw new AppDaoException("Unable to connect", err);
		}
	}

	public Scheme getSchemeById(int id) throws AppDaoException{
		try {
			return ht.get(Scheme.class,id);
		}
		catch(Exception e)
		{
			throw new AppDaoException("Couldn't connect to db", e);
		}
	}
	
	public String updateScheme(int id) {
		return null;
	}

	public List<Scheme> getAllSchemes() throws AppDaoException {
		List<Scheme> el = new ArrayList<Scheme>();
		try {
			el = ht.loadAll(Scheme.class);
			return el;
		}
		catch(Exception e)
		{
			throw new AppDaoException("Couldn't connect to db", e);
		}
	}


	public String deleteScheme(int id) {
		return null;
	}

	
}
