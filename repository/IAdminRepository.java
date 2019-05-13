package com.nareshit.repository;

import org.springframework.data.repository.CrudRepository;

import com.nareshit.domain.Admin;

public interface IAdminRepository extends CrudRepository<Admin, Integer> {

}
