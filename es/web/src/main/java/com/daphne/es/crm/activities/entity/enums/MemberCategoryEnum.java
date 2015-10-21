package com.daphne.es.crm.activities.entity.enums;

public enum MemberCategoryEnum {
	
	/*
	 * 本次活动限制的会员类别，会员类别如下： 000 全体会员（不分类别） 001 普通会员 002 银卡会员 003 金卡会员 004 白金卡会员
	 * 999 其他
	 */
	
	cash("全体会员",000),
	ordinary("普通会员", 001),
	silver("银卡会员", 002),
	gold("金卡会员", 003),
	platinum("白金卡会员", 004),
	other("其他", 999);
	private final String info;
	private final Integer key;
	public String getInfo() {
		return info;
	}
	public Integer getKey() {
		return key;
	}

	private MemberCategoryEnum(String info,int key) {
		this.info=info;
		this.key=key;
	}

}
