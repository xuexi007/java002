package com.offcn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.offcn.po.Sp;
import com.offcn.service.SpService;

@Controller
public class SpController {

	@Autowired
	SpService service;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<Sp> getSpList(String begindate,String enddate){
		List<Sp> list=service.getSpByBeginToEnd(begindate, enddate);
		
		return list;
		
	}
}
