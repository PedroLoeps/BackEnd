package com.PhSystem.BackEnd.Repo;

import com.PhSystem.BackEnd.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepo extends JpaRepository<Client, String> {

}
