package com.thoughtworks.dddworkshop.application;


import com.thoughtworks.dddworkshop.domain.command.PerformPayment;
import com.thoughtworks.dddworkshop.domain.shared.CommandFailure;
import com.thoughtworks.dddworkshop.domain.vo.PaymentId;
import com.thoughtworks.dddworkshop.domain.vo.PaymentStatus;
import io.vavr.Tuple2;
import io.vavr.control.Either;

import java.util.concurrent.CompletionStage;

public interface PaymentProcessManager {
    CompletionStage<Either<CommandFailure, Tuple2<PaymentId, PaymentStatus>>> process(PerformPayment command);
}
