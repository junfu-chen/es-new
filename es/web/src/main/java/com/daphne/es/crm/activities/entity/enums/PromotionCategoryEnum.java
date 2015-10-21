package com.daphne.es.crm.activities.entity.enums;

public enum PromotionCategoryEnum {
//	优惠券类别：1.现金券(与POS复杂促销不重叠)、2.折扣券（现价）、3.折扣券（原价）、5.POS简单促销、4.POS复杂促销
	
	cash("现金券(与POS复杂促销不重叠)",1),
	currentprice("折扣券(现价)",2),
	costprice("折扣券(原价)",3),
	complex("POS复杂促销",4),
	simpleness("POS简单促销",5);
	private final String info;
	private final Integer key;
	public String getInfo() {
		return info;
	}
	public Integer getKey() {
		return key;
	}

	private PromotionCategoryEnum(String info,int key) {
		this.info=info;
		this.key=key;
	}
}
