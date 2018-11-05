package com.offcn.service;

import java.util.List;


import com.offcn.po.Sp;

public interface SpService {
	//保存
		public void save(Sp sp);
		
		//批量保存
		public void saves(List<Sp> list);
		
		//读取商品信息，传递参数 开始时间、结束时间
		
		public List<Sp> getSpByBeginToEnd(String begindate,String enddate);
}
