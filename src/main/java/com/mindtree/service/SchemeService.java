package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Scheme;
import com.mindtree.exceptions.dao.AppDaoException;
import com.mindtree.exceptions.service.AppServiceException;

public interface SchemeService {

	String addScheme(Scheme s) throws AppServiceException;
	String updateScheme(int id) throws AppServiceException;
	List<Scheme> getAllSchemes() throws AppServiceException;
	Scheme getSchemeById(int id) throws AppServiceException;
	String deleteScheme(int id) throws AppServiceException;
	float SchemeValue(int id, int maturity, int amount) throws AppServiceException;
}
