package com.thoughtworks.dddworkshop.domain.command.validation;

import com.thoughtworks.dddworkshop.domain.command.PerformPayment;
import com.thoughtworks.dddworkshop.domain.shared.CommandFailure;
import com.thoughtworks.dddworkshop.domain.shared.CommandValidation;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

@Component
public class PerformPaymentValidator implements CommandValidation<PerformPayment> {

    @Override
    public Either<CommandFailure, PerformPayment> acceptOrReject(PerformPayment command) {

        return Either.right(command);
    }
}
