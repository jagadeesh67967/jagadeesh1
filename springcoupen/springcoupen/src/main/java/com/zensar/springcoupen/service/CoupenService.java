package com.zensar.springcoupen.service;

import java.util.List;

import com.zensar.springcoupen.dto.CoupenDto;


public interface CoupenService {
	
	public CoupenDto getCoupen(int CoupenId);

	//public List<CoupenDto> getCoupens();
	public List<CoupenDto> getCoupens(int pageNumber,int pageSize);

	public CoupenDto insertCoupen(CoupenDto coupenDto);

	public void updateCoupen(int CoupenId, CoupenDto coupenDto);

	public void deleteCoupen(int CoupenId);

	public List<CoupenDto> getByCoupenCode(String coupenCode);

	public List<CoupenDto> getByCoupenCodeAndExpDate(String coupenCode, String expDate);

	//public List<CoupenDto> getByCoupenCodeOrderByExpDate(String coupenCode);


}
