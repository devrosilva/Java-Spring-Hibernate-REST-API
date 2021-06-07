package orange.talents.restapi.challenge.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import orange.talents.restapi.challenge.model.Vehicle;

@Component
public class DateCheckService implements IDateCheckService{
	
	@Override
	public String checkRestrictionDay(Vehicle vehicle) {
		
		Map<Integer, String> trafficRestrictionDay = new HashMap<>();
		
		trafficRestrictionDay.put(0,"segunda-feira");
		trafficRestrictionDay.put(1,"segunda-feira");
		trafficRestrictionDay.put(2,"terça-feira");
		trafficRestrictionDay.put(3,"terça-feira");
		trafficRestrictionDay.put(4,"quarta-feira");
		trafficRestrictionDay.put(5,"quarta-feira");
		trafficRestrictionDay.put(6,"quinta-feira");
		trafficRestrictionDay.put(7,"quinta-feira");
		trafficRestrictionDay.put(8,"sexta-feira");
		trafficRestrictionDay.put(9,"sexta-feira");
		
		//Checks if the year's last digit value is between from 1 and 9
		if(Character.getNumericValue(vehicle.getYear().charAt(3)) >=0 && Character.getNumericValue(vehicle.getYear().charAt(3)) <= 9) {
			
			return trafficRestrictionDay.get(Character.getNumericValue(vehicle.getYear().charAt(3)));
		}
		return null;
	}
	
	@Override
	public boolean checkRestrictionStatus(Vehicle vehicle) {
		
		Calendar calendar = Calendar.getInstance();
		Map<String, Integer> trafficRestrictionStatus = new HashMap<>();
		
		trafficRestrictionStatus.put("domingo",1);
		trafficRestrictionStatus.put("segunda-feira",2);
		trafficRestrictionStatus.put("terça-feira",3);
		trafficRestrictionStatus.put("quarta-feira",4);
		trafficRestrictionStatus.put("quinta-feira",5);
		trafficRestrictionStatus.put("sexta-feira",6);
		trafficRestrictionStatus.put("sabado",7);
		
		//Checks whether today's code matches the vehicle's restriction day or not.
		if(calendar.get(Calendar.DAY_OF_WEEK) == trafficRestrictionStatus.get(vehicle.getTrafficRestrictionDay())) {
			
			return true; 
		}
		return false;
	}
}
