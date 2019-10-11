package com.thoughtworks.dddworkshop.infrastructure.persistence.repository;

import com.thoughtworks.dddworkshop.infrastructure.persistence.mapping.PaymentEventTable;
import org.springframework.data.repository.CrudRepository;

public interface EventStore extends CrudRepository<PaymentEventTable, String> {
}
