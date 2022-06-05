package com.kafka.sync;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProduceCallbackDemo {
    public static void main(String[] args) {

        //0.配置属性
        Properties properties = new Properties();
        //链接集群
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "lc:39092");
        //指定对应的key/value序列化类型     org.apache.kafka.common.serialization.StringSerializer
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());


        //1.创建kafka生产者对象
        KafkaProducer<String, String> kafkaProducer = new KafkaProducer<>(properties);


        //2.发送数据
        for (int i = 0;i<=5;i++){
            kafkaProducer.send(new ProducerRecord<>("caopei", "yibu" + i), new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if(e==null){
                        System.out.println("主题"+recordMetadata.topic()+"\t"+"分区"+recordMetadata.partition());
                    }
                }
            });
        }

        //3.关闭资源
        kafkaProducer.close();
    }
}
