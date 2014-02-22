package com.ems.bo;

import com.ems.dao.LoginDao;
import com.ems.exceptions.BusinessException;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.LoginTo;

public class LoginBo {

	public void checkUserPassword(LoginTo lto) throws DatabaseExceptions, BusinessException
	{
		LoginDao ldao = new LoginDao();
		ldao.getLoginDetails(lto.getUserName(),lto.getPassword());
	}
}
