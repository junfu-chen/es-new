package com.daphne.es.crm.activities.entity.enums;

public enum ActivityStatusEnum {
	manuscript("草稿",1),underway("进行中",2),finish("结束",3);
	private final String info;
	private final Integer key;
	
	public String getInfo() {
		return info;
	}

	public Integer getKey() {
		return key;
	}

	private ActivityStatusEnum(String info, Integer key) {
		this.info=info;
		this.key=key;
		
	}


	
	

}
