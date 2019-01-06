package com.mindtree.exceptions.dao;

import com.mindtree.exceptions.AppException;

public class AppDaoException extends AppException {

	public AppDaoException() {
		super();
	}

	public AppDaoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public AppDaoException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public AppDaoException(String arg0) {
		super(arg0);
	}

	public AppDaoException(Throwable arg0) {
		super(arg0);
	}
	
}
