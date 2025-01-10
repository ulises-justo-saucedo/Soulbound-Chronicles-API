package com.chocolatada.Soulbound.Chronicles.API.services;

import java.util.ArrayList;

public interface IBasicOperations<T> {
    T save(T obj) throws Exception;
    T update(T obj) throws Exception;
    T getById(long id) throws Exception;
    ArrayList<T> getAll();
}
