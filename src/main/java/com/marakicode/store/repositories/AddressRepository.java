package com.marakicode.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.marakicode.store.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
