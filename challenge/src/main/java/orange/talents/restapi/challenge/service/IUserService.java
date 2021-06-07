package orange.talents.restapi.challenge.service;

import orange.talents.restapi.challenge.model.User;


public interface IUserService {
	
	public User registerUser(User newUser);
	
	public User getUser(Integer id);

	public User getUser(String cpf);
	
	public boolean checkIfUserExists(Integer id);
	
	public boolean checkIfUserExists(String cpf);
	
	public User getOwner(Integer id);
	
	public User getOwner(String cpf);
}
