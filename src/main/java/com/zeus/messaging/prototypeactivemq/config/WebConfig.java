package com.zeus.messaging.prototypeactivemq.config;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@Configuration
public class WebConfig {


    @Bean
    public ActiveMQQueue queue(){
        return new ActiveMQQueue("standalone.queue");
    }

    @Bean
    public JmsListenerContainerFactory warehouseFactory(ConnectionFactory factory, DefaultJmsListenerContainerFactoryConfigurer configurer){
        DefaultJmsListenerContainerFactory containerFactory = new DefaultJmsListenerContainerFactory();
        configurer.configure(containerFactory, factory);
        return containerFactory;
    }

}
