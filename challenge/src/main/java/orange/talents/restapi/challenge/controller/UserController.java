package orange.talents.restapi.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import orange.talents.restapi.challenge.model.User;
import orange.talents.restapi.challenge.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService iUserService;
	
	@PostMapping("/registeruser")
	public ResponseEntity<User> registerUser(@RequestBody User newUser){
		User result = iUserService.registerUser(newUser);
		if(result != null){
			return ResponseEntity.status(201).body(result);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/search/user/id")
	public ResponseEntity<User> getUser(@RequestParam(name="value") Integer id){
		User result =  iUserService.getUser(id);
		if(result != null) {
			return ResponseEntity.ok().body(result);
		}
		System.out.println("User not found.");
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/search/user/cpf")
	public ResponseEntity<User> getUser(@RequestParam(name="value") String cpf){
		User result =  iUserService.getUser(cpf);
		if(result != null) {
			return ResponseEntity.ok().body(result);
		}
		System.out.println("User not found.");
		return ResponseEntity.notFound().build();
	}
}
