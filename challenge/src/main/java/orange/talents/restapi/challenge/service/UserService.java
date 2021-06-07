package orange.talents.restapi.challenge.service;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import orange.talents.restapi.challenge.dao.IUserDao;
import orange.talents.restapi.challenge.model.User;
import orange.talents.restapi.challenge.model.Vehicle;

@Component
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private DateCheckService dateCheckService;

	@Override
	public User registerUser(User newUser) {
		//Checks some conditions before persisting the user.
		try {
			if( (newUser.getName() != null && newUser.getName().trim().length() > 0) &&
				(newUser.getEmail().matches("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")) &&
				(newUser.getCpf().trim().length() == 11) &&
				(newUser.getBirthDate().trim().length() == 8) ){
				
				userDao.save(newUser);
				return newUser;
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
	
	//Methods used at the GET EndPoints
	@Override
	public User getUser(Integer id) {
		
		try {
			User user = userDao.findById(id).get();
			Iterator<Vehicle> iterator = user.getVehicle().iterator();
			Vehicle vehicle;
			//Checks whether today's status restriction is true or false.
			while(iterator.hasNext()) {
				vehicle = iterator.next();
				if(vehicle.getTrafficRestrictionDay() != null && dateCheckService.checkRestrictionStatus(vehicle)) {
					vehicle.setTrafficRestrictionStatus(true);
				}
				else {
					vehicle.setTrafficRestrictionStatus(false);
				}
			}
			return userDao.findById(id).get();
		}
		catch(NoSuchElementException ex) {
			System.out.println("User not found.");
		}
		catch(Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		return null;
	}
	
	@Override
	public User getUser(String cpf) {
		try {
			User user = userDao.findByCpf(cpf).get();
			Iterator<Vehicle> iterator = user.getVehicle().iterator();
			Vehicle vehicle;
			//Checks whether today's status restriction is true or false. 
			while(iterator.hasNext()) {
				vehicle = iterator.next();
				if(vehicle.getTrafficRestrictionDay() != null && dateCheckService.checkRestrictionStatus(vehicle)) {
					vehicle.setTrafficRestrictionStatus(true);
				}
				else {
					vehicle.setTrafficRestrictionStatus(false);
				}
			}
			return userDao.findByCpf(cpf).get();
		}
		catch(NoSuchElementException ex) {
			System.out.println("User not found.");
		}
		catch(Exception ex) {
			System.out.println("Error: " + ex.getMessage());
		}
		return null;
	}
	
	//Methods intended to be used at vehicle registration
	public User getOwner(Integer id) {
		
		return userDao.findById(id).get();
	}
	
	public User getOwner(String cpf) {
		
		return userDao.findByCpf(cpf).get();
	}
	
	public boolean checkIfUserExists(Integer id) {
		
		return userDao.existsById(id);
	}
	
	public boolean checkIfUserExists(String cpf) {
		
		return userDao.existsByCpf(cpf);
	}
}
