package com.sotas.billboard05.repository;

import java.sql.Connection;

public interface JdbcRepository {
    Connection getConnection();
}
