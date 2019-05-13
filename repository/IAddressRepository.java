package com.nareshit.repository;

import org.springframework.data.repository.CrudRepository;

import com.nareshit.domain.Address;

public interface IAddressRepository extends CrudRepository<Address, Integer> {

}
