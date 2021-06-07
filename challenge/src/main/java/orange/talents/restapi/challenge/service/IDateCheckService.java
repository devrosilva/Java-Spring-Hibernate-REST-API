package orange.talents.restapi.challenge.service;

import orange.talents.restapi.challenge.model.Vehicle;

public interface IDateCheckService {

	public boolean checkRestrictionStatus(Vehicle vehicle);
	
	public String checkRestrictionDay(Vehicle vehicle);
}
