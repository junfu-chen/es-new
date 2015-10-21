package com.daphne.es.crm.activities.web.controller.entity;

public enum ActivityNodeType {
	Activity("活动类型"), activityStep("活动阶段"), activityContent("活动内容");
	private final String info;

	private ActivityNodeType(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}
}
