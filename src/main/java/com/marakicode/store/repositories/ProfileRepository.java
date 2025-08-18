package com.marakicode.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.marakicode.store.entities.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
