package com.sotas.billboard05.repository;

import java.util.List;

public interface CrudRepository<E, PK> {
    E add(E e);
    E get(PK pk);
    E update(E e);
    E remove(PK pk);
    List<E> getAll();
}
