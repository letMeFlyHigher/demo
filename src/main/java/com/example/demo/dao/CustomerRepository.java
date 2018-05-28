package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long>{
    List<Customer> findByEmail(String email);

    List<Customer> findByDate(Date date);

    @Query("select c from Customer c where c.email = :email")
    Stream<Customer> findByEmailReturnStream(@Param("email") String email);

}
