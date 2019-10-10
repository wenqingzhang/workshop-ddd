package com.thoughtworks.dddworkshop.persistence.repository;

import com.thoughtworks.dddworkshop.persistence.mapping.PaymentEventTable;
import org.springframework.data.repository.CrudRepository;

public interface EventStore extends CrudRepository<PaymentEventTable, String> {
}
