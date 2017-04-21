package rabbitmq.ha.consumer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import rabbitmq.ha.domain.Order;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);
    private static AtomicLong total = new AtomicLong();
    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    public void receiveMessage(Order order) {
    	logger.info(String.format("[received message:%d]%s",total.incrementAndGet(),order.toString()));
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
