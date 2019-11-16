package com.htffund.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class KafkaProducter {
	private final KafkaProducer<String, String> producer;
	public final static String TOPIC = "test0811";

	private KafkaProducter() {
		Properties properties = new Properties();
		// 此处配置的是kafka的端口
		properties.put("bootstrap.servers", "127.0.0.1:9092");

		properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		properties.put("request.required.acks", "-1");

		producer = new KafkaProducer<>(properties);
	}

	void produce() {
		// 发送100条消息
		int messageNo = 100;
		int count = 200;
		while (messageNo < count) {
			String key = String.valueOf(messageNo);
			String data = "hello kafka message " + key;
			long startTime = System.currentTimeMillis();
			
			ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, key, data);
			producer.send(record, new DataCallback(startTime, data));
			System.out.println(data);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			messageNo++;
		}
	}

	public static void main(String[] args) {
		new KafkaProducter().produce();
	}
}
