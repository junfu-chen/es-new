package com.daphne.es.crm.activities.repository;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.daphne.es.common.plugin.entity.TransientTreeable;
import com.daphne.es.common.plugin.web.controller.entity.ZTree;
import com.daphne.es.common.web.bind.util.ZTreeUtils;
import com.daphne.es.crm.activities.entity.CrmActivity;
import com.daphne.es.crm.activities.entity.CrmActivityActivitysManager;
import com.daphne.es.crm.activities.entity.CrmActivityAd;
import com.daphne.es.crm.activities.entity.CrmActivityHpoint;
import com.daphne.es.crm.activities.entity.CrmActivityPromotion;
import com.daphne.es.crm.activities.entity.CrmActivitySteps;
import com.daphne.es.crm.activities.service.CrmActivityService;
import com.daphne.es.crm.activities.service.CrmActivityStepsService;
import com.daphne.es.test.BaseIT;
import com.google.common.collect.Lists;

public class CrmActivityRepositoryTest extends BaseIT {
	
	@Autowired
	private CrmActivityService crmActivityService;
	
	@Autowired
	private CrmActivityStepsService crmActivityStepsService;

	
	@Test
	public void test() {
		
		//System.out.println(crmActivityRepository.findOne(BigDecimal.valueOf(1)).getCrmActivityStepsList().size());;
//		Searchable searchable=Searchable.newSearchable();
//		searchable.addSearchParam("caId_eq", 1);
//		assertEquals(crmActivityStepsService.findAll(searchable).getContent().size(), 1);
		//crmActivityRepository.findAll().get(0).getCrmActivityActivitysManagers()
		 
		CrmActivity activity=new CrmActivity();
		activity.setDiy("树节点测试");
		activity.setTitle("树节点测试3");
		CrmActivitySteps step=new CrmActivitySteps();
		step.setDiy("树节点测试");
		step.setTitle("树节点测试阶段3");
		CrmActivityAd ad=new CrmActivityAd();
		ad.setTitle("树节点测试广告3");
		step.getCrmActivityAds().add(ad);
		CrmActivityPromotion promotion=new CrmActivityPromotion();
		promotion.setTitle("促销活动3");
		activity.getCrmActivitySteps().add(step);

		
		step.setCrmActivity(activity);
		ad.setCrmActivitySteps(step);
		ad.setCrmActivity(activity);
		crmActivityService.save(activity);
		
		
//		List<TransientTreeable<BigDecimal>> models = Lists.newArrayList();
//		CrmActivity activity = crmActivityService.findOne(BigDecimal.valueOf(133));
//		activity.setParentId(BigDecimal.valueOf(0));
//		activity.setParentIds("");
//		models.add(activity);
//		List<CrmActivitySteps> crmActivityStepsList = activity.getCrmActivitySteps();
//		// 关联活动和阶段
//		ZTreeUtils.relation(crmActivityStepsList, activity);
//		models.addAll(crmActivityStepsList);
//		// 遍历每一个阶段
//		for (CrmActivitySteps step : crmActivityStepsList) {
//			//// 关联阶段和广告
//			List<CrmActivityAd> crmActivityAds = step.getCrmActivityAds();
//			ZTreeUtils.relation(crmActivityAds, step);
//			models.addAll(crmActivityAds);
//			//// 关联阶段和广告
//			List<CrmActivityPromotion> Promotions = step.getCrmActivityPromotions();
//			ZTreeUtils.relation(Promotions, step);
//			models.addAll(Promotions);
//			//// 关联阶段和广告
//			List<CrmActivityHpoint> crmActivityHpoints = step.getCrmActivityHpoints();
//			ZTreeUtils.relation(crmActivityHpoints, step);
//			models.addAll(crmActivityHpoints);
//			//// 关联阶段和广告
//			List<CrmActivityActivitysManager> crmActivityActivitysManagers = step.getCrmActivityActivitysManagers();
//			ZTreeUtils.relation(crmActivityActivitysManagers, step);
//			models.addAll(crmActivityActivitysManagers);
//
//		}
//
//		System.out.println(JSON.toJSON(ZTreeUtils.convertToZtreeListIdTotal("", models, false, false)));;
//		
		
	}
	

}
