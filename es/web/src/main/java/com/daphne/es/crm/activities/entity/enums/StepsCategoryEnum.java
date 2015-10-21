package com.daphne.es.crm.activities.entity.enums;

public enum StepsCategoryEnum {
	/*阶段类别：1 广告推送， 2 会员促销，3 抢兑码， 4 赠送积分,5 优惠券*/
	adpush("广告推送",1),
	promotion("会员促销",2),
	scramblecode("抢兑码",3),
	resentintegral("积分赠送",4),
	coupon("优惠券",5);
	private final String info;
	private final Integer key;
	public String getInfo() {
		return info;
	}
	public Integer getKey() {
		return key;
	}

	private StepsCategoryEnum(String info,int key) {
		this.info=info;
		this.key=key;
		
		
	}

}
