package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Bank;
import com.mindtree.exceptions.dao.AppDaoException;

public interface BankDao {

	List<Bank> getAllBank() throws AppDaoException;
}
