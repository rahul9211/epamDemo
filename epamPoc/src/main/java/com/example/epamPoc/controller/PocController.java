package com.example.epamPoc.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.epamPoc.entity.DatabasesDetail;
import com.example.epamPoc.service.DatabaseService;

@RestController
@RequestMapping("/poc")
public class PocController {

	@Autowired
	private DatabaseService service;
	
	@PostMapping(path = "/save")
	public void save()
	{
		 service.saveDetail();	
	}
	
	@GetMapping(path = "/getDbDetail")
	public List<DatabasesDetail> getDetail()
	{
		
		return service.getDatabaseInfo();	
	}
	
	@GetMapping(path = "/getReconDetail")
	public List<DatabasesDetail> getDeltaDetail() throws IOException
	{
		
		return service.getReconInfo();	
	}
}
