package orange.talents.restapi.challenge.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import orange.talents.restapi.challenge.model.User;

public interface IUserDao extends CrudRepository<User, Integer> {
	
	public Optional<User> findById(Integer id);
	
	public Optional<User> findByCpf(String cpf);
	
	public boolean existsById(Integer id);
	
	public boolean existsByCpf(String cpf);
}
