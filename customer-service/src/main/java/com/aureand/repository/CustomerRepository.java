package com.aureand.repository;

import com.aureand.repository.entity.Customer;
import com.aureand.repository.entity.Region;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    public Customer findByNumberID(String numberID);

    public List<Customer> findByLastName(String lastName);

    public List<Customer> findByRegion(Region region);
}
