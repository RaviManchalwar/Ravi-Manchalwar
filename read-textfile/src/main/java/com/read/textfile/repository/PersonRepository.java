package com.read.textfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.read.textfile.entity.Person;
import com.read.textfile.entity.PersonId;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {
}