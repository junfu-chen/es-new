package com.daphne.es.crm.activities.entity.enums;

public enum OnlineToOfflineEnum {
	Online("线上",1),Offline("线下",2);
	private final String info;
	private final Integer key;
	public String getInfo() {
		return info;
	}
	public Integer getKey() {
		return key;
	}
	private OnlineToOfflineEnum(String info,int key) {
		this.info=info;
		this.key=key;
	}
}
