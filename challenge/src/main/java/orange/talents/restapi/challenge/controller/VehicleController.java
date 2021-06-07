package orange.talents.restapi.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import orange.talents.restapi.challenge.model.Vehicle;
import orange.talents.restapi.challenge.service.IVehicleService;

@RestController
public class VehicleController {
	
	@Autowired
	private IVehicleService iVehicleService;

	@PostMapping("/registervehicle")
	public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle newVehicle){

		Vehicle result = iVehicleService.registerVehicle(newVehicle);
		
		if(result != null) {
			return ResponseEntity.status(201).body(newVehicle);
		}
		return ResponseEntity.badRequest().build();
	}
}
