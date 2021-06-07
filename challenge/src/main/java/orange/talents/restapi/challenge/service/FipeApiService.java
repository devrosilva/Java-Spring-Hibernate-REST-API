package orange.talents.restapi.challenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import orange.talents.restapi.challenge.dto.FipeApi;
import orange.talents.restapi.challenge.model.Vehicle;
import reactor.core.publisher.Mono;

//Service created to consume the third part API Fipe Api
@Service
public class FipeApiService implements IFipeApiService{

	@Autowired
	private WebClient webClient;
	
	private String code;
	private String url;
	private FipeApi result;
	private Mono<FipeApi> request;
	
	@Override
	public String getPrice(Vehicle vehicle) {
		
		url = "/" + vehicle.getVehicleType() + "/marcas";
		//Gets Brands and Codes; Saves the Brand code in the variable code; Changes the url for the next request.
		Mono<FipeApi[]> arrayRequest = this.webClient
									   	   .method(HttpMethod.GET)
									   	   .uri(url)
									   	   .retrieve()
									   	   .bodyToMono(FipeApi[].class);	
		FipeApi[] arrayResult = arrayRequest.block();
		
		for(int i = 0; i < arrayResult.length; i++) {
			if(arrayResult[i].getNome().equals(vehicle.getBrand())) {
				code = arrayResult[i].getCodigo();
				url = url + "/" + code + "/modelos";
				break;
			}
		}
		//Gets Models and Years; Saves the Model code in the variable code; Changes the url for the next request. Does the some with Year.
		request = this.webClient
					  .method(HttpMethod.GET)
				  	  .uri(url)
				  	  .retrieve()
				  	  .bodyToMono(FipeApi.class);	
		result = request.block();

		for(int i = 0; i < result.getModelos().length; i++) {
			if(result.getModelos()[i].getNome().equals(vehicle.getModel())) {
				code = result.getModelos()[i].getCodigo();
				url = url + "/" + code + "/anos";
				break;
			}
		}
		
		for(int i = 0; i < result.getAnos().length; i++) {
			if( result.getAnos()[i].getNome().contains(vehicle.getYear())) {
				code = result.getAnos()[i].getCodigo();
				url = url + "/" + code;
				break;
			}
		}
		
		//Does the final request and return the price
		request = this.webClient
				    			  .method(HttpMethod.GET)
				    			  .uri(url)
				    			  .retrieve()
				    			  .bodyToMono(FipeApi.class);
		result = request.block();
		return result.getValor();
	}
}
