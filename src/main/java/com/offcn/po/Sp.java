package com.offcn.po;

import java.util.Date;

public class Sp {
private Integer id;
private String name;
private float lowprice;
private float avgprice;
private float hprice;
private String guige;
private String unit;
private Date createdate;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getLowprice() {
	return lowprice;
}
public void setLowprice(float lowprice) {
	this.lowprice = lowprice;
}
public float getAvgprice() {
	return avgprice;
}
public void setAvgprice(float avgprice) {
	this.avgprice = avgprice;
}
public float getHprice() {
	return hprice;
}
public void setHprice(float hprice) {
	this.hprice = hprice;
}
public String getGuige() {
	return guige;
}
public void setGuige(String guige) {
	this.guige = guige;
}
public String getUnit() {
	return unit;
}
public void setUnit(String unit) {
	this.unit = unit;
}
public Date getCreatedate() {
	return createdate;
}
public void setCreatedate(Date createdate) {
	this.createdate = createdate;
}
@Override
public String toString() {
	return "Sp [id=" + id + ", name=" + name + ", lowprice=" + lowprice + ", avgprice=" + avgprice + ", hprice="
			+ hprice + ", guige=" + guige + ", unit=" + unit + ", createdate=" + createdate + "]";
}




}
