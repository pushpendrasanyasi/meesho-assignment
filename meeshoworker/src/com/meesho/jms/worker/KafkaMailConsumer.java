package com.meesho.jms.worker;

import java.util.Collections;
import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.meesho.jms.entities.GenericBrokerMessage;
import com.meesho.rest.client.GenericRestClient;
import com.meesho.rest.client.RestRequestType;

public class KafkaMailConsumer {

	private final static String TOPIC = "new-order-mail-topic";
	private final static String BOOTSTRAP_SERVERS = "localhost:9000";
	private final static String MAIL_NOTIFICATION_SERVICE_ENDPOINT = "http://localhost:8080/sendmailnotification";

	private static Consumer<String, GenericBrokerMessage> createConsumer() {
		final Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "KafkaConsumer");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class.getName());
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

		// Create the consumer using props.
		final Consumer<String, GenericBrokerMessage> consumer = new KafkaConsumer<>(props);

		// Subscribe to the topic.
		consumer.subscribe(Collections.singletonList(TOPIC));
		return consumer;
	}

	// call this method to run the consumer from any process
	static void runConsumer() throws InterruptedException {
		final Consumer<String, GenericBrokerMessage> consumer = createConsumer();

		while (true) {
			final ConsumerRecords<String, GenericBrokerMessage> consumerRecords = consumer.poll(100);

			consumerRecords.forEach(record -> {
				Gson gson = new Gson();
				String jsonPayload = gson.toJson(record.value());

				GenericRestClient restClient = new GenericRestClient();
				String[] headers = null;
				Response response = restClient.callRestApi(MAIL_NOTIFICATION_SERVICE_ENDPOINT + "/newmail", headers,
						RestRequestType.POST, "", jsonPayload);

				int httpstatus = response.getStatus();
				System.out.println(httpstatus);
				// this will print the current status of the new mail notification
				String status = response.readEntity(String.class);
				// System.out.println(response.readEntity(String.class));
				if (httpstatus == 200)
					consumer.commitAsync();
				else {
					// initiate fail over workflow
					// fail over logic need to be decided
				}

			});

		}

	}

}
