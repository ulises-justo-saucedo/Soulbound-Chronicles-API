package com.chocolatada.Soulbound.Chronicles.API.services;

import java.util.ArrayList;

public interface IBasicOperations<T, U> {
    T save(T obj) throws Exception;
    T update(T obj) throws Exception;
    T getById(U id) throws Exception;
    ArrayList<T> getAll();
}
