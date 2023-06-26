package in.eshwarnaz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import in.eshwarnaz.constants.Constants;
import in.eshwarnaz.entity.Order;

@Service
public class KafakaProducerService {

	@Autowired
	private KafkaTemplate<String, Order> kafkaTemplate;

	public String addMsg(Order order) {

		// publish msg to kafka topic
		kafkaTemplate.send(Constants.TOPIC, order);
		return "Msg Published To Kafka Topic";
	}
}
