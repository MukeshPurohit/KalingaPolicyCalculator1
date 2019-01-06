package com.mindtree.service;

import java.util.List;

import com.mindtree.entity.Bank;
import com.mindtree.exceptions.service.AppServiceException;

public interface BankService {

	List<Bank> getAllBank() throws AppServiceException;
}
