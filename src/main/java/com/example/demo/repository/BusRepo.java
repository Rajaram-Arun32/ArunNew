package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Busses;
@Repository
public interface BusRepo extends JpaRepository<Busses,Integer>{

}
