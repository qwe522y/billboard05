package com.sotas.billboard05.service;

import com.sotas.billboard05.entity.Owner;
import com.sotas.billboard05.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface OwnerService {
    Map<Integer, Owner> getAsMap();
}
