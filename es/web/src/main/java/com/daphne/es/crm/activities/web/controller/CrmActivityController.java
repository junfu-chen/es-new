package com.daphne.es.crm.activities.web.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daphne.es.common.entity.search.Searchable;
import com.daphne.es.common.plugin.entity.TransientTreeable;
import com.daphne.es.common.web.bind.annotation.PageableDefaults;
import com.daphne.es.common.web.bind.util.ZTreeUtils;
import com.daphne.es.common.web.controller.BaseCRUDController;
import com.daphne.es.crm.activities.entity.CrmActivity;
import com.daphne.es.crm.activities.entity.CrmActivityActivitysManager;
import com.daphne.es.crm.activities.entity.CrmActivityAd;
import com.daphne.es.crm.activities.entity.CrmActivityCoupon;
import com.daphne.es.crm.activities.entity.CrmActivityHpoint;
import com.daphne.es.crm.activities.entity.CrmActivityPromotion;
import com.daphne.es.crm.activities.entity.CrmActivitySteps;
import com.daphne.es.crm.activities.entity.enums.ActivityStatusEnum;
import com.daphne.es.crm.activities.service.CrmActivityActivitysBcounterselectionService;
import com.daphne.es.crm.activities.service.CrmActivityActivitysManagerService;
import com.daphne.es.crm.activities.service.CrmActivityAdService;
import com.daphne.es.crm.activities.service.CrmActivityHpointService;
import com.daphne.es.crm.activities.service.CrmActivityPromotionService;
import com.daphne.es.crm.activities.service.CrmActivityStepsService;
import com.google.common.collect.Lists;

@Controller
@RequestMapping(value = "/activities/activity")
public class CrmActivityController extends BaseCRUDController<CrmActivity, BigDecimal> {

	public CrmActivityController() {
		setResourceIdentity("activities:activity");
	}

	/**
	 * 活动阶段
	 */
	@Autowired
	private CrmActivityStepsService crmActivityStepsService;

	/**
	 * 活动广告
	 */
	@Autowired
	private CrmActivityAdService crmActivityAdService;
	/**
	 * 活动促销
	 */
	@Autowired
	private CrmActivityPromotionService crmActivityPromotionService;
	/**
	 * 活动赠送积分
	 */
	@Autowired
	private CrmActivityHpointService crmActivityHpointService;
	/**
	 * 活动抢对码管理
	 */
	@Autowired
	private CrmActivityActivitysManagerService crmActivityActivitysManagerService;

	@Autowired
	private CrmActivityActivitysBcounterselectionService crmActivityActivitysBcounterselectionService;

	@RequestMapping(value = "tree", method = RequestMethod.GET)
	@PageableDefaults(sort = { "parentIds=asc", "weight=asc" })
	public String tree(HttpServletRequest request,

			@RequestParam(value = "async", required = false, defaultValue = "false") boolean async,
			Searchable searchable, Model model) {

		if (permissionList != null) {
			permissionList.assertHasViewPermission();
		}

		List<TransientTreeable<BigDecimal>> models = Lists.newArrayList();
		CrmActivity activity = baseService.findOne(BigDecimal.valueOf(Long.valueOf(150)));
		activity.setParentId(BigDecimal.valueOf(0));
		activity.setParentIds("");
		models.add(activity);
		List<CrmActivitySteps> crmActivityStepsList = activity.getCrmActivitySteps();
		// 关联活动和阶段
		ZTreeUtils.relation(crmActivityStepsList, activity);
		models.addAll(crmActivityStepsList);
		// 遍历每一个阶段
		for (CrmActivitySteps step : crmActivityStepsList) {
			//// 关联阶段和广告
			List<CrmActivityAd> crmActivityAds = step.getCrmActivityAds();
			ZTreeUtils.relation(crmActivityAds, step);
			models.addAll(crmActivityAds);
			//// 关联阶段和促销
			List<CrmActivityPromotion> Promotions = step.getCrmActivityPromotions();
			ZTreeUtils.relation(Promotions, step);
			models.addAll(Promotions);
			//// 关联阶段和积分
			List<CrmActivityHpoint> crmActivityHpoints = step.getCrmActivityHpoints();
			ZTreeUtils.relation(crmActivityHpoints, step);
			models.addAll(crmActivityHpoints);
			//// 关联阶段和抢对码
			List<CrmActivityActivitysManager> crmActivityActivitysManagers = step.getCrmActivityActivitysManagers();
			ZTreeUtils.relation(crmActivityActivitysManagers, step);
			models.addAll(crmActivityActivitysManagers);
			//// 关联阶段和抢对码
			List<CrmActivityCoupon> crmActivityCoupons = step.getCrmActivityCoupons();
			ZTreeUtils.relation(crmActivityCoupons, step);
			models.addAll(crmActivityCoupons);

		}

		model.addAttribute("trees",
				ZTreeUtils.convertToZtreeListIdTotal(request.getContextPath(), models, async, true));

		return viewName("tree/tree");
	}

	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main() {

		if (permissionList != null) {
			permissionList.assertHasViewPermission();
		}

		return viewName("tree/main");
	}

	// statusList
	@Override
	protected void setCommonData(Model model) {
		model.addAttribute("statusList", ActivityStatusEnum.values());
		Searchable searchable = Searchable.newSearchable();
		model.addAttribute("brandList",
				crmActivityActivitysBcounterselectionService.findAllWithNoPageNoSort(searchable));
	}

}
