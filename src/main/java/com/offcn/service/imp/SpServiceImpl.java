package com.offcn.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.SpDao;
import com.offcn.po.Sp;
import com.offcn.service.SpService;
@Service
public class SpServiceImpl implements SpService {

	@Autowired
	SpDao spDao;
	@Override
	public void save(Sp sp) {
		spDao.save(sp);
	}

	@Override
	public void saves(List<Sp> list) {
		spDao.saves(list);

	}

	@Override
	public List<Sp> getSpByBeginToEnd(String begindate, String enddate) {
		
		return spDao.getSpByBeginToEnd(begindate, enddate);
	}

}
