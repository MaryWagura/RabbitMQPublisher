package com.rabbitmq.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMqApplication implements CommandLineRunner {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//to sent without an exchange, routing key that is set :: sent to default AMQP queue
//		rabbitTemplate.convertAndSend("hello from first message");

		//with an exchange & key set
//		rabbitTemplate.convertAndSend("TestExchange", "testRouting", "hello from code");

		//with DTO
		SimpleMessage simpleMessage= new SimpleMessage();
		simpleMessage.setName("FirstMessage");
		simpleMessage.setDescription("SimpleDescription");
		rabbitTemplate.convertAndSend("MyTopicExchange", "topic", simpleMessage);

	}
}
