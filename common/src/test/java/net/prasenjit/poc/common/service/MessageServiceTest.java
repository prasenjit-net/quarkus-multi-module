package net.prasenjit.poc.common.service;


import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
class MessageServiceTest {

    @Inject
    MessageService messageService;

    @Test
    void testGetMessage() {
        UniAssertSubscriber<String> subscriber = messageService.getMessage()
                .subscribe().withSubscriber(UniAssertSubscriber.create());

        subscriber.assertCompleted().assertItem("Hello World!");
    }
}
