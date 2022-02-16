package net.prasenjit.poc.common.service;

import io.smallrye.mutiny.Uni;

import javax.inject.Singleton;

@Singleton
public class MessageService {
    public Uni<String> getMessage() {
        return Uni.createFrom().item("Hello World");
    }
}
