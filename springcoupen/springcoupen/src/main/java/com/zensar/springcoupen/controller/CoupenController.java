package com.zensar.springcoupen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.springcoupen.dto.CoupenDto;
import com.zensar.springcoupen.service.CoupenService;

@RestController
@RequestMapping(value = "/coupon-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class CoupenController {
	
	@Autowired
	private CoupenService coupenService;

// @GetMapping(value = "/coupen/{coupenId}",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
   @GetMapping(value = "/coupen/{coupenId}")
// public CoupenDto getCoupen(@PathVariable("coupenId") int CoupenId) {
	public ResponseEntity<CoupenDto> getCoupen(@PathVariable("coupenId") int CoupenId) {
// return coupenService.getCoupen(CoupenId);
		return new ResponseEntity<CoupenDto>(coupenService.getCoupen(CoupenId), HttpStatus.OK);
	}

//@GetMapping(value = "/coupens",produces = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	@GetMapping(value = "/coupens")
// public List<CoupenDto> getCoupens() {
//public ResponseEntity<List<CoupenDto>> getCoupens() {
	public ResponseEntity<List<CoupenDto>> getCoupens(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "3") int pageSize) {
// return coupenService.getCoupens();
		return new ResponseEntity<List<CoupenDto>>(coupenService.getCoupens(pageNumber, pageSize), HttpStatus.OK);
	}

//@PostMapping(value = "/coupens",consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@PostMapping(value = "/coupens")
// public CoupenDto insertCoupen(@RequestBody CoupenDto coupenDto) {
	public ResponseEntity<CoupenDto> insertCoupen(@RequestBody CoupenDto coupenDto) {
// return coupenService.insertCoupen(coupenDto);
		return new ResponseEntity<CoupenDto>(coupenService.insertCoupen(coupenDto), HttpStatus.CREATED);
	}

//@PutMapping(value = "coupens/{coupenId}",consumes = { MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	@PutMapping(value = "coupens/{coupenId}")
// public void updateCoupen(@PathVariable("coupenId") int CoupenId, @RequestBody CoupenDto coupenDto) {
	public ResponseEntity<String> updateCoupen(@PathVariable("coupenId") int CoupenId,
			@RequestBody CoupenDto coupenDto) {
		coupenService.updateCoupen(CoupenId, coupenDto);
		return new ResponseEntity<String>("Coupen updated Succesfully", HttpStatus.OK);

	}

	@DeleteMapping("coupens/{coupenId}")
// public void deleteCoupen(@PathVariable("coupenId") int CoupenId) {
	public ResponseEntity<String> deleteCoupen(@PathVariable("coupenId") int CoupenId) {
		coupenService.deleteCoupen(CoupenId);
		return new ResponseEntity<String>("Coupen deleted Succesfully", HttpStatus.OK);
	}

	@GetMapping("coupens/code/{coupenCode}")
	public ResponseEntity<List<CoupenDto>> getByCoupenCode(@PathVariable("coupenCode") String coupenCode) {
		return new ResponseEntity<List<CoupenDto>>(coupenService.getByCoupenCode(coupenCode), HttpStatus.OK);
	}

	@GetMapping("coupens/date/{coupenCode}/{expDate}")
	public ResponseEntity<List<CoupenDto>> getByCoupenCodeAndExpDate(@PathVariable("coupenCode") String coupenCode,
			@PathVariable("expDate") String expDate) {
		return new ResponseEntity<List<CoupenDto>>(coupenService.getByCoupenCodeAndExpDate(coupenCode, expDate),
				HttpStatus.OK);
	}

	

}
