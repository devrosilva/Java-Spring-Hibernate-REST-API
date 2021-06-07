package orange.talents.restapi.challenge.dao;

import org.springframework.data.repository.CrudRepository;

import orange.talents.restapi.challenge.model.Vehicle;

public interface IVehicleDao extends CrudRepository<Vehicle, Integer>{

}
