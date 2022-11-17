package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.demo.model.DmCnDvSuDung;
import com.example.demo.request.DCDSDRequest;

public interface DCDSudungService {
	List<DmCnDvSuDung> findByCriteria(DCDSDRequest dCDSDRequest,Pageable pageable);
	
	List<DmCnDvSuDung> getDmCnDvSuDungs();

	DmCnDvSuDung saveDmCnDvSuDung(DmCnDvSuDung dmCnDvSuDung);

	DmCnDvSuDung getDmCnDvSuDung(Long id);

	void deleteDmCnDvSuDung(Long id);

	DmCnDvSuDung updateDmCnDvSuDung(DmCnDvSuDung dmCnDvSuDung);
	

}
