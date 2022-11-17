package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.JDBCCall.JDBCStoredProcedureRead;
import com.example.demo.model.DmCnDvSuDung;
import com.example.demo.request.DCDSDRequest;
import com.example.demo.service.DCDSudungService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/dcdsd")
public class DmCnDvSuDungController {
	
	@Autowired
	private DCDSudungService dService;
	
	@PostMapping("/add")
	public ResponseEntity<DmCnDvSuDung> addDmCnDvSuDung(@RequestBody DmCnDvSuDung dmCnDvSuDung) {
		return new ResponseEntity<>(dService.saveDmCnDvSuDung(dmCnDvSuDung), HttpStatus.CREATED);
	}
	
	@PostMapping("/{pageNumber}")
	public ResponseEntity<List<DmCnDvSuDung>> findByCriteria(@PathVariable int pageNumber,@RequestBody DCDSDRequest dCDSDRequest){
		Pageable pages = PageRequest.of(pageNumber,5,Sort.by(Direction.ASC, "id"));
		return new ResponseEntity<>(dService.findByCriteria(dCDSDRequest,pages),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public DmCnDvSuDung getDCDSD(@PathVariable("id") Long id) {
		return dService.getDmCnDvSuDung(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteDmCnDvSuDung(@PathVariable("id") Long id) {
		dService.deleteDmCnDvSuDung(id);
		return new ResponseEntity<HttpStatus>( HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DmCnDvSuDung> updateDmCnDvSuDung(@PathVariable("id") Long id,@RequestBody DmCnDvSuDung dmCnDvSuDung) {
		dmCnDvSuDung.setId(id);
		return new ResponseEntity<DmCnDvSuDung>(dService.saveDmCnDvSuDung(dmCnDvSuDung),HttpStatus.OK);
	}
	
	
	@GetMapping("/JDBC")
	public void getDmCnDvSuDungs(){
		JDBCStoredProcedureRead.getAll();
	}
	
	@GetMapping("/JDBC/{id}")
	public void getDmCnDvSuDungs(@PathVariable("id") Long id){
		JDBCStoredProcedureRead.findById(id);
	}
}
