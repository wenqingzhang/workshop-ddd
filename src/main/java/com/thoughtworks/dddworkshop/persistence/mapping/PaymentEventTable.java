package com.thoughtworks.dddworkshop.persistence.mapping;


import com.thoughtworks.dddworkshop.vo.PaymentEventType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = {"eventData", "timestamp"})
@ToString
@Entity
public class PaymentEventTable {
    @Id
    private String eventId;
    private PaymentEventType eventType;
    private String paymentId;
    private LocalDateTime timestamp;
    @Column(length = 1024)
    private String eventData;
}
