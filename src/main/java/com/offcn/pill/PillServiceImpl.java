package com.offcn.pill;

public class PillServiceImpl implements PillInterface {

	@Override
	public void pill(Float money) {
		System.out.println("支付成功:"+money);

	}

}
