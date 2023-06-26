package in.eshwarnaz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.eshwarnaz.entity.Order;
import in.eshwarnaz.service.KafakaProducerService;

@RestController
public class KafkaProducerController {

	@Autowired
	KafakaProducerService service;
	
	@PostMapping("/order")
	public String createOrder(@RequestBody Order order) {
		String msg = service.addMsg(order);
		return msg;
	}
}
