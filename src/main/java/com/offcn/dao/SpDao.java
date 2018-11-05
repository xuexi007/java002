package com.offcn.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.offcn.po.Sp;

public interface SpDao {
    //保存
	public void save(Sp sp);
	
	//批量保存
	public void saves(List<Sp> list);
	
	//读取商品信息，传递参数 开始时间、结束时间
	
	public List<Sp> getSpByBeginToEnd(@Param("begindate") String begindate,@Param("enddate")String enddate);
}
