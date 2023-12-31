package in.eshwarnaz.configration;

import in.eshwarnaz.constants.Constants;
import in.eshwarnaz.entity.Order;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class ApcheProduceConfig {
	@Bean
	public ProducerFactory<String, Order> producerFactory() {

		Map<String, Object> configProps = new HashMap<String, Object>();

		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.HOST);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		return new DefaultKafkaProducerFactory<String, Order>(configProps);
	}

	@Bean
	public KafkaTemplate<String, Order> kafkaTemplate() {
		return new KafkaTemplate<String, Order>(producerFactory());
	}
}
