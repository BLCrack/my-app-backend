package com.findme.myappbackend.repositories;

import com.findme.myappbackend.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String>
{
}

