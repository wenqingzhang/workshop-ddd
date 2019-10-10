package com.thoughtworks.dddworkshop.persistence.repository;

import com.thoughtworks.dddworkshop.persistence.mapping.PaymentEventTable;
import com.thoughtworks.dddworkshop.persistence.po.PaymentEvent;
import com.thoughtworks.dddworkshop.utils.json.JsonMapper;
import com.thoughtworks.dddworkshop.vo.PaymentEventId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Repository
public class PaymentEventRepository {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentEventRepository.class);

    private final EventStore eventStore;
    private final JsonMapper jsonMapper;

    PaymentEventRepository(EventStore eventStore, JsonMapper jsonMapper) {
        this.eventStore = eventStore;
        this.jsonMapper = jsonMapper;
    }

    public CompletionStage<PaymentEventId> store(PaymentEvent paymentEvent) {
        LOG.debug("Storing paymentEvent {}", paymentEvent);
        String eventDataAsJson = jsonMapper.write(paymentEvent);
        LOG.debug("eventDataAsJson {}", eventDataAsJson);
        PaymentEventTable paymentEventTable = new PaymentEventTable();
        paymentEventTable.setEventId(paymentEvent.getEventId().id);
        paymentEventTable.setEventType(paymentEvent.getEventType());
        paymentEventTable.setPaymentId(paymentEvent.getPaymentId().id);
        paymentEventTable.setTimestamp(paymentEvent.getTimestamp());
        paymentEventTable.setEventData(eventDataAsJson);
        eventStore.save(paymentEventTable);
        return CompletableFuture.completedFuture(paymentEvent.getEventId());
    }
}
