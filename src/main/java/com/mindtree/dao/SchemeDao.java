package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Scheme;
import com.mindtree.exceptions.dao.AppDaoException;

public interface SchemeDao {

	void addScheme(Scheme s) throws AppDaoException;
	String updateScheme(int id) throws AppDaoException;
	List<Scheme> getAllSchemes() throws AppDaoException;
	Scheme getSchemeById(int id) throws AppDaoException;
	String deleteScheme(int id) throws AppDaoException;
}
