package com.icogroup.baseprojectdatabinding.data.connection.repositories;

/**
 * Created by Ulises.harris on 6/17/16.
 */
public interface RepositoryInterface<T> {

    void onSuccess(T item);
    void onFailure(String error);
}
