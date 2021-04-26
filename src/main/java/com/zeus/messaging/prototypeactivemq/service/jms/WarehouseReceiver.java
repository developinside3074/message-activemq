package com.zeus.messaging.prototypeactivemq.service.jms;

import com.zeus.messaging.prototypeactivemq.pojos.BookOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class WarehouseReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseReceiver.class);


    private final WarehouseProcessingService warehouseProcessingService;

    @Autowired
    public WarehouseReceiver(WarehouseProcessingService warehouseProcessingService) {
        this.warehouseProcessingService = warehouseProcessingService;
    }


    @JmsListener(destination = "book.order.queue")
    public void receiver(BookOrder bookOrder){
        LOGGER.info("receiver a message");
        LOGGER.info("Message is == " + bookOrder);

        //Optional
//        if(bookOrder.getBook().getTitle().startsWith("L")){
//            throw new RuntimeException("bookOrderId=" + bookOrder.getBookOrderId() + " is of a book not allowed!");
//        }

        warehouseProcessingService.processOrder(bookOrder);
    }
}
