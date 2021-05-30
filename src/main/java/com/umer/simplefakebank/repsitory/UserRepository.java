package com.umer.simplefakebank.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umer.simplefakebank.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long	>{

}
