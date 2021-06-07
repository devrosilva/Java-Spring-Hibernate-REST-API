package orange.talents.restapi.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import orange.talents.restapi.challenge.dao.IVehicleDao;
import orange.talents.restapi.challenge.model.Vehicle;

//Service created to set the vehicle's attributes before persisting it.
@Component
public class VehicleService implements IVehicleService {

	@Autowired
	private IDateCheckService dateCheckService;
	
	@Autowired
	private IFipeApiService fipeApiService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IVehicleDao vehicleDao;
	
	@Override
	public Vehicle registerVehicle(Vehicle newVehicle) {
		
		//Try to fill the object vehicle with an User or return null if User doesn't exist
		try {
			if(userService.checkIfUserExists(newVehicle.getUser().getCpf())) {
				newVehicle.setUser(userService.getOwner(newVehicle.getUser().getCpf()));
			}
			else if(userService.checkIfUserExists(newVehicle.getUser().getId())) {
				newVehicle.setUser(userService.getOwner(newVehicle.getUser().getId()));
			}
			else {
				System.out.println("User does not exist.");
				return null;
			}
		}
		catch(Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			return null;
		}
		
		try {
			if( (newVehicle.getBrand().trim().length() > 0) && (newVehicle.getModel().trim().length() > 0) &&
				(newVehicle.getYear().trim().length() > 0) ){

				//Try to get the vehicle's price
				try {
					newVehicle.setPrice(fipeApiService.getPrice(newVehicle));
				}
				catch(Exception ex) {
					System.out.println("Error trying to set the price: " + ex.getMessage());
				}
				
				//Try to set the trafficRestrictionDay for the vehicle
				try {
					newVehicle.setTrafficRestrictionDay(dateCheckService.checkRestrictionDay(newVehicle));
				}
				catch(Exception ex) {
					System.out.println("Error trying to set the trafficDayRestriction: " + ex.getMessage());
				}
				
				vehicleDao.save(newVehicle);
				return vehicleDao.save(newVehicle);
			}
		}
		catch(IllegalArgumentException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		catch(Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		return null;
	}
}
