package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DmCnDvSuDung;

@Repository
public interface DCDSudungRepository extends JpaRepository<DmCnDvSuDung, Long>, JpaSpecificationExecutor<DmCnDvSuDung> {
  
}
