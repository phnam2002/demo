package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.model.DmCnDvSuDung;
import com.example.demo.repository.DCDSudungRepository;
import com.example.demo.request.DCDSDRequest;
import com.example.demo.service.DCDSudungService;

@Service
 public class DCDSudungServiceImpl implements DCDSudungService {
	
	@Autowired
	private DCDSudungRepository dRepo;
	
	public DCDSudungServiceImpl(DCDSudungRepository dRepo) {
		this.dRepo = dRepo;
	}

	@Override
	public DmCnDvSuDung saveDmCnDvSuDung(DmCnDvSuDung dmCnDvSuDung) {
		return dRepo.save(dmCnDvSuDung);
	}

	@Override
	public DmCnDvSuDung getDmCnDvSuDung(Long id) {
		Optional<DmCnDvSuDung> dmCnDvSuDungOptional = dRepo.findById(id);
		if (dmCnDvSuDungOptional.isPresent()) {
			return dmCnDvSuDungOptional.get();
		}
		throw new RuntimeException("Id invalid " + id);
	}

	@Override
	public void deleteDmCnDvSuDung(Long id) {
		dRepo.deleteById(id);
	}

	@Override
	public DmCnDvSuDung updateDmCnDvSuDung(DmCnDvSuDung dmCnDvSuDung) {
		return dRepo.save(dmCnDvSuDung);
	}

	@Override
	public List<DmCnDvSuDung> findByCriteria(DCDSDRequest dCDSDRequest,Pageable pageable) {
		Page<DmCnDvSuDung> page =  dRepo.findAll(new Specification<DmCnDvSuDung>() {

			private static final long serialVersionUID = 7302112543821888186L;

			@Override
			public Predicate toPredicate(Root<DmCnDvSuDung> root, CriteriaQuery<?> query,
					CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				
				if (dCDSDRequest.getMa() != null && dCDSDRequest.getMa() != "") {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("ma"),"%"+ dCDSDRequest.getMa() +"%")));
				}
				if (dCDSDRequest.getTenNgan() != null && dCDSDRequest.getTenNgan() != "") {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("tenNgan"),"%"+ dCDSDRequest.getTenNgan() +"%")));
				}
				if (dCDSDRequest.getDiaChiCn() != null && dCDSDRequest.getDiaChiCn() != "") {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("diaChiCn"),"%"+ dCDSDRequest.getDiaChiCn() +"%")));
				}
				if (dCDSDRequest.getMaSoThue() != null && dCDSDRequest.getMaSoThue() != "") {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("maSoThue"),"%"+ dCDSDRequest.getMaSoThue() +"%")));
				}
				if (dCDSDRequest.getNguoiTao() != null && dCDSDRequest.getNguoiTao() != "") {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("nguoiTao"),"%"+ dCDSDRequest.getNguoiTao() +"%")));
				}
				if (dCDSDRequest.getTenDayDu() != null && dCDSDRequest.getTenDayDu() != "") {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("tenDayDu"),"%"+ dCDSDRequest.getTenDayDu() +"%")));
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		},pageable);
	    page.getTotalElements();
        System.out.println(page.getTotalElements());
        page.getTotalPages();      
        System.out.println(page.getTotalPages());
        return page.getContent();
	}


	@Override
	public List<DmCnDvSuDung> getDmCnDvSuDungs() {
		return dRepo.findAll();
	}

}
