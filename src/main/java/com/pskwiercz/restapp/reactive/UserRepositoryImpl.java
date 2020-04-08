package com.pskwiercz.restapp.reactive;

import reactor.core.publisher.Flux;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
    private Map<Integer, User> users = null;

    public UserRepositoryImpl() {
        users = Map.of(
                1, (new User(1, "David")),
                2, (new User(2, "John")),
                3, (new User(3, "Kevin"))
        );
    }

    @Override
    public Flux<User> getAllUsers() {
        return Flux.fromIterable(this.users.values());
    }
}
