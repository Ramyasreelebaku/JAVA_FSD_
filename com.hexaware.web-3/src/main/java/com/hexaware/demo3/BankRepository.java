package com.hexaware.demo3;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<Bank, Integer>{

}
