package com.zensar.springcoupen.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.zensar.springcoupen.dto.CoupenDto;
import com.zensar.springcoupen.entity.Coupen;
import com.zensar.springcoupen.repository.CoupenRepository;


@Service
public class CoupenServiceImpl implements CoupenService{
	
	@Autowired
	private CoupenRepository coupenRepository;

	@Autowired
	private ModelMapper modelMapper;

	public CoupenServiceImpl() {
	}

	@Override
	public CoupenDto getCoupen(int coupenId) {
		Coupen getCoupen = coupenRepository.findById(coupenId).get();
		return modelMapper.map(getCoupen,CoupenDto.class);
		// return mapToDto(getCoupen);
	}

	@Override
	//public List<CoupenDto> getCoupens() {
	public List<CoupenDto> getCoupens(int pageNumber,int pageSize) {
		//List<Coupen> listOfCoupens = coupenRepository.findAll();
		//Page<Coupen> findAll = coupenRepository.findAll(PageRequest.of(1, 5));
		Page<Coupen> findAll = coupenRepository.findAll(PageRequest.of(pageNumber,pageSize));
		List<Coupen> content = findAll.getContent();
		List<CoupenDto> listOfCoupenDto = new ArrayList<CoupenDto>();
		/*
		 * for (Coupen coupen : listOfCoupens) {
		 * //listOfCoupenDto.add(mapToDto(coupen));
		 * listOfCoupenDto.add(modelMapper.map(coupen,CoupenDto.class)); }
		 */
		for(Coupen coupen:content) 
			listOfCoupenDto.add(modelMapper.map(coupen,CoupenDto.class));
		return listOfCoupenDto;
	}

	@Override
	public CoupenDto insertCoupen(CoupenDto coupenDto) {
		/*
		 * Coupen coupen = new Coupen(); coupen.setCoupenId(coupenDto.getCoupenId());
		 * coupen.setCoupenCode(coupenDto.getCoupenCode());
		 * coupen.setExpDate(coupenDto.getExpDate());
		 */
		//Coupen coupen = mapToEntity(coupenDto);
		Coupen coupen = modelMapper.map(coupenDto,Coupen.class);
		Coupen insertedCoupen = coupenRepository.save(coupen);
		//return mapToDto(insertedCoupen);
		return modelMapper.map(insertedCoupen,CoupenDto.class);

	}

	@Override
	public void updateCoupen(int coupenId, CoupenDto coupenDto) {
		/*
		 * Coupen coupen = new Coupen(); coupen.setCoupenId(coupenDto.getCoupenId());
		 * coupen.setCoupenCode(coupenDto.getCoupenCode());
		 * coupen.setExpDate(coupenDto.getExpDate());
		 */
		//Coupen coupen = mapToEntity(coupenDto);
		Coupen coupen = modelMapper.map(coupenDto,Coupen.class);
		coupenRepository.save(coupen);

	}

	@Override
	public void deleteCoupen(int coupenId) {
		coupenRepository.deleteById(coupenId);

	}

	@Override
	public List<CoupenDto> getByCoupenCode(String coupenCode) {
		//List<Coupen> findBycoupenCode = coupenRepository.findByCoupenCode(coupenCode);
		List<Coupen> findBycoupenCode = coupenRepository.test(coupenCode);
		List<CoupenDto> coupenDtos = new ArrayList<CoupenDto>();
		for(Coupen coupen:findBycoupenCode)
			coupenDtos.add(modelMapper.map(coupen,CoupenDto.class));
		return coupenDtos;
	}

	

	@Override
	public List<CoupenDto> getByCoupenCodeAndExpDate(String coupenCode, String expDate) {
		//List<Coupen> findBycoupenCode = coupenRepository.findByCoupenCodeAndExpDate(coupenCode, expDate);
		List<Coupen> findBycoupenCode = coupenRepository.test1(coupenCode,expDate);
		List<CoupenDto> coupenDtos = new ArrayList<CoupenDto>();
		for(Coupen coupen:findBycoupenCode)
			coupenDtos.add(modelMapper.map(coupen,CoupenDto.class));
		return coupenDtos;
	}
	



	/*
	 * public Coupen mapToEntity(CoupenDto coupenDto) { Coupen coupon = new Coupen(); coupen.setCoupenId(coupenDto.getCoupenId());
	 * coupen.setCoupenCode(coupenDto.getCoupenCode());
	 * coupen.setExpDate(coupenDto.getExpDate()); return coupen; }
	 */
	/*
	 * public CoupenDto mapToDto(Coupen coupen) { CoupenDto coupenDto = new CoupenDto(); coupenDto.setCoupenId(coupen.getCoupenId());
	 * coupenDto.setCoupenCode(coupen.getCoupenCode());
	 * coupenDto.setExpDate(coupen.getExpDate()); return couponDto; }
	 */

}
