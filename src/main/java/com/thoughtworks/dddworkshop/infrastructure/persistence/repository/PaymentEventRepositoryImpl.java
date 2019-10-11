package com.thoughtworks.dddworkshop.infrastructure.persistence.repository;


import com.thoughtworks.dddworkshop.domain.entity.PaymentEventRepository;
import com.thoughtworks.dddworkshop.domain.event.PaymentEvent;
import com.thoughtworks.dddworkshop.domain.vo.PaymentEventId;
import com.thoughtworks.dddworkshop.infrastructure.persistence.mapping.PaymentEventTable;
import com.thoughtworks.dddworkshop.infrastructure.util.json.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Repository
class PaymentEventRepositoryImpl implements PaymentEventRepository {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentEventRepositoryImpl.class);

    private final EventStore eventStore;
    private final JsonMapper jsonMapper;

    PaymentEventRepositoryImpl(EventStore eventStore,
                               JsonMapper jsonMapper) {
        this.eventStore = eventStore;
        this.jsonMapper = jsonMapper;
    }

    @Override
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
