package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DmCnDvSuDung;

@Repository
public interface DCDSudungRepository extends JpaRepository<DmCnDvSuDung, Long>, JpaSpecificationExecutor<DmCnDvSuDung> {
  
}
