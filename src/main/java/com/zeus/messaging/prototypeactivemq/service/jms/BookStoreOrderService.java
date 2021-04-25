package com.zeus.messaging.prototypeactivemq.service.jms;

import com.zeus.messaging.prototypeactivemq.pojos.BookOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class BookStoreOrderService {

    private static final String BOOK_QUEUE = "book.order.queue";

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(BookOrder bookOrder){
        jmsTemplate.convertAndSend(BOOK_QUEUE, bookOrder);
    }
}
