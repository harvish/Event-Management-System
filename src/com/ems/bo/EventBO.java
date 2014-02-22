package com.ems.bo;

import com.ems.dao.EventDAO;
import com.ems.exceptions.BusinessException;
import com.ems.exceptions.DatabaseExceptions;
import com.ems.model.EventDetails;

public class EventBO {
	public void addEvent(com.ems.model.EventDetails event) throws DatabaseExceptions 
	{
		new EventDAO().insertEvent(event);
	}

	public void checkCustomerID(String customerId) throws BusinessException, DatabaseExceptions {
		new EventDAO().checkCustomer(customerId);
	}

	public void editEvent(EventDetails event) throws DatabaseExceptions {
		new EventDAO().editEvent(event);
	}

	public String fetchDetails(String customerId, String eventId) throws BusinessException {
		return new EventDAO().fetchEventDetails(customerId,eventId);
	}
}
 