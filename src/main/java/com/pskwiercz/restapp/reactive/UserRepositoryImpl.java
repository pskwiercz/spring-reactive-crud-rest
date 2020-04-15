package com.pskwiercz.restapp.reactive;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

    private Map<Integer, User> users = new HashMap<>();

    public UserRepositoryImpl() {
        this.users.put(100, new User(100, "David"));
        this.users.put(101, new User(101, "John"));
        this.users.put(102, new User(102, "Kevin"));
    }

    @Override
    public Flux<User> getAllUsers() {
        return Flux.fromIterable(users.values());
    }

    @Override
    public Mono<User> getUser(Integer id) {
        return Mono.justOrEmpty(users.get(id));
    }

    @Override
    public Mono<Void> saveUser(Mono<User> userMono) {
        return userMono.doOnNext(user -> {
            users.put(user.getUserid(), user);
            System.out.format("<><><> Saved %s with id %d%n", user, user.getUserid());
        }).thenEmpty(Mono.empty());
    }

    @Override
    public Mono<Void> updateUser(Mono<User> userMono) {
        return userMono.doOnNext(user -> {
            users.put(user.getUserid(), user);
            System.out.format("Saved %s with id %d%n", user, user.getUserid());
        }).thenEmpty(Mono.empty());
    }

    @Override
    public Mono<Void> deleteUser(Integer id) {
        System.out.println("Delete user : " + users.get(id));
        users.remove(id);
        return Mono.empty();
    }
}
