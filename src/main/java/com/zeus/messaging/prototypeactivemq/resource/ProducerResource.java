package com.zeus.messaging.prototypeactivemq.resource;

import com.zeus.messaging.prototypeactivemq.pojos.BookOrder;
import com.zeus.messaging.prototypeactivemq.service.jms.BookStoreOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.Queue;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    BookStoreOrderService bookStoreOrderService;

    @Autowired
    Queue queue;

    @GetMapping("/{message}")
    public String publish(@PathVariable("message") final String message) {

        jmsTemplate.convertAndSend(queue, message);

        return "Publish Successfully";
    }

    @GetMapping("/order")
    public String publishOrderBook(@RequestBody BookOrder bookOrder) {

        bookStoreOrderService.send(bookOrder);

        return "Publish Order Successfully";
    }
}
