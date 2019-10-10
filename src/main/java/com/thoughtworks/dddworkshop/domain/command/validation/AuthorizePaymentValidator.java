package com.thoughtworks.dddworkshop.domain.command.validation;

import com.thoughtworks.dddworkshop.domain.command.AuthorizePayment;
import com.thoughtworks.dddworkshop.domain.shared.CommandFailure;
import com.thoughtworks.dddworkshop.domain.shared.CommandValidation;
import io.vavr.control.Either;
import org.springframework.stereotype.Component;

@Component
public class AuthorizePaymentValidator implements CommandValidation<AuthorizePayment> {

    @Override
    public Either<CommandFailure, AuthorizePayment> acceptOrReject(AuthorizePayment command) {
        return Either.right(command);
    }
}
