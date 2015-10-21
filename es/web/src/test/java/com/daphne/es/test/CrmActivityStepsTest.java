package com.daphne.es.test;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.daphne.es.crm.activities.entity.CrmActivity;
import com.daphne.es.crm.activities.entity.CrmActivitySteps;
import com.daphne.es.crm.activities.entity.CrmActivityVipScripts;
import com.daphne.es.crm.activities.repository.CrmActivityRepository;
import com.daphne.es.crm.activities.repository.CrmActivityStepsRepository;
import com.daphne.es.crm.activities.service.CrmActivityService;
import com.daphne.es.crm.activities.service.CrmActivityStepsService;

public class CrmActivityStepsTest extends BaseIT{
	
	
	
	@Autowired
	private CrmActivityStepsRepository crmActivityStepsRepository;
	
	@Autowired
	private CrmActivityStepsService crmActivityStepsService;
	
	@Autowired
	private CrmActivityService crmActivityService;
	
	@Autowired
	private CrmActivityRepository crmActivityRepository;

	//@Test
	public void test() {
		crmActivityStepsRepository.findAll();
		}
	
	@Test
	@Transactional
	public void testsave(){
//		CrmActivity crmActivity = new CrmActivity();
//		CrmActivitySteps crmActivitySteps = new CrmActivitySteps();
//		CrmActivityVipScripts scripts=new CrmActivityVipScripts();
//		crmActivitySteps.setCrmActivity(crmActivity);
//		crmActivity.setBrand("junfu");
//		crmActivitySteps.setCrmActivityVipScripts(scripts);
//		//----添加活动阶段表
//		
//		crmActivitySteps.setTitle("test1");
//		crmActivitySteps.setStartDate(new Date());
//		crmActivitySteps.setEndDate(new Date());
//		
//		scripts.setScripts("select * from dual");
//		scripts.setControlRate(BigDecimal.valueOf(10));
//		scripts.setCrmActivitySteps(crmActivitySteps); 
//		scripts.setCrmActivity(crmActivity);
//		
//		crmActivityStepsService.save(crmActivitySteps);
//		CrmActivity activity =	crmActivityService.findOne(BigDecimal.valueOf(95));
//		
//		Assert.assertEquals(activity.getBrand(), "junfu");
//		Assert.assertEquals(activity.getCrmActivitySteps().size(), 1);
//		Assert.assertEquals(activity.getCrmActivitySteps().get(0).getTitle(), "test1");
//		Assert.assertEquals(activity.getCrmActivityVipScripts().get(0).getScripts(), "select * from dual");
//		activity.setBrand("junfu1");
//		activity.getCrmActivitySteps().get(0).setTitle("test11");
//		activity.getCrmActivityVipScripts().get(0).setScripts("select 'x' from dual");
//		crmActivityService.save(activity);
		
		CrmActivitySteps crmActivitySteps =	crmActivityStepsService.findOne(BigDecimal.valueOf(95));
		
		Assert.assertEquals(crmActivitySteps.getTitle(),"junfu");
		Assert.assertEquals(crmActivitySteps.getCrmActivityVipScripts().getScripts(), "select * from dual");
	
//		activity.setBrand("junfu1");
//		activity.getCrmActivitySteps().get(0).setTitle("test11");
//		activity.getCrmActivityVipScripts().get(0).setScripts("select 'x' from dual");
		crmActivityStepsService.save(crmActivitySteps);
		
		CrmActivitySteps rmActivitySteps = crmActivityStepsService.findOne(BigDecimal.valueOf(95)); 
		Assert.assertEquals(rmActivitySteps.getTitle(), "112473");
		
	}

}
