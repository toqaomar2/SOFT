package com.app.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDb, Integer> {
    // Additional custom queries can be added here if needed
    boolean existsByName(String name);

    @Query("SELECT c FROM CustomerDb c WHERE LOWER(c.name) = LOWER(:name) AND LOWER(c.pass) = LOWER(:password)")
    Optional<CustomerDb> findByUsernameAndPassword(@Param("name") String name, @Param("password") String password);

}

