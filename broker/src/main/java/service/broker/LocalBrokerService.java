package service.broker;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import service.core.ClientApplication;
import service.core.ClientInfo;
import service.core.Quotation;

import static java.util.Arrays.asList;

/**
 * Implementation of the broker service that uses the Service Registry.
 * 
 * @author Rem
 *
 */
@RestController
public class LocalBrokerService {

	public static Map<Long, ClientInfo> cache = new HashMap<>();
	public static int SEED_ID = 0;
	static List<String> arrayList = new ArrayList<>(asList("http://localhost:8081/quotations", "http://localhost:8082/quotations", "http://localhost:8083/quotations"));
	HashMap<Integer, ClientApplication> applications = new HashMap<Integer, ClientApplication>() {};


	@RequestMapping(value = "/application", method = RequestMethod.POST)
	public ClientApplication getApplication(@RequestBody ClientInfo info) throws MalformedURLException {

		ClientApplication clientApplication = new ClientApplication();
		System.out.println(info);

		clientApplication.setQuotationList(getQuotations(info));
		clientApplication.setClientInfo(info);
		clientApplication.setSEED_ID(SEED_ID);
		applications.put(SEED_ID++,clientApplication);

		return clientApplication;
	}

	public List<Quotation> getQuotations(ClientInfo info) throws MalformedURLException {

		List<Quotation> quotations = new LinkedList<Quotation>();
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<ClientInfo> request = new HttpEntity<>(info);

		for (String url : arrayList) {
			try {
//			URL uri = new URL(url);
				Quotation quotation = restTemplate.postForObject(url, request, Quotation.class);
				quotations.add(quotation);
			} catch (Exception e) {
				System.out.println(e);
				continue;
			}
		}
		return quotations;
	}

	@RequestMapping(value = "/application", method = RequestMethod.GET)
	public List<ClientApplication> returnApplication(@RequestBody ClientInfo info){

		List<ClientApplication> list = new ArrayList<ClientApplication>(applications.values());
		return list;
	}

	@RequestMapping(value = "/application/{SEED_ID}", method = RequestMethod.GET)
	public ClientApplication getSpecificApplication(@PathVariable("SEED_ID") int parameter){
		return applications.get(parameter);
	}
}
