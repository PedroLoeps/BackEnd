package com.PhSystem.BackEnd.Repo;

import com.PhSystem.BackEnd.Models.CanView;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CanViewRepo  extends JpaRepository<CanView, Integer> {

    List<CanView> findByClient(String client);
}
