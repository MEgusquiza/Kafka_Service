package com.bank.service;

import java.util.Map;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CRUDService <T,ID>{
     T findById(ID id);
     //T findAll();
    Map<String, T> findAll();
    void update(T entity);
    void save(T entity);
    void delete(ID id);

}
