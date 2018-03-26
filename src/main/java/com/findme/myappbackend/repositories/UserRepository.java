package com.findme.myappbackend.repositories;

import com.findme.myappbackend.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, String>
{
}

