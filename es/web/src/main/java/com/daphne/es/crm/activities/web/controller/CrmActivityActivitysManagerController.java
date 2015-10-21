package com.daphne.es.crm.activities.web.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daphne.es.common.Constants;
import com.daphne.es.common.web.controller.BaseCRUDController;
import com.daphne.es.crm.activities.entity.CrmActivity;
import com.daphne.es.crm.activities.entity.CrmActivityActivitysManager;

import com.daphne.es.crm.activities.entity.CrmActivitySteps;
import com.daphne.es.crm.activities.service.CrmActivityService;

@Controller
@RequestMapping(value = "/activities/activitys")
public class CrmActivityActivitysManagerController extends BaseCRUDController<CrmActivityActivitysManager, BigDecimal> {

	public CrmActivityActivitysManagerController() {
		setResourceIdentity("activities:activitys");
	}
	
	@Autowired
	private CrmActivityService crmActivityService;
	
	@RequestMapping(value = "{caId}/{casId}/create", method = RequestMethod.GET)
	public String createWithActivitysManager(Model model, @Valid @ModelAttribute("m") CrmActivityActivitysManager m,
			BindingResult result, @RequestParam(value = "caId", required = false) BigDecimal caId,
			@RequestParam(value = "casId", required = false) BigDecimal casId, RedirectAttributes redirectAttributes,CrmActivity crmactivity) {
		if (permissionList != null) {
			this.permissionList.assertHasCreatePermission();
		}

		setCommonData(model);
		model.addAttribute(Constants.OP_NAME, "新增");
		if (!model.containsAttribute("m")) {
			CrmActivity crmActivity = crmActivityService.findOne(caId);
			model.addAttribute("m", new CrmActivityActivitysManager(crmActivity));
		}
		return viewName("editForm");
	}

	@RequestMapping(value = "{caId}/{casId}/create", method = RequestMethod.POST)
	public String createWithActivitysManager(Model model, @Valid @ModelAttribute("m") CrmActivityActivitysManager m,
			BindingResult result, @RequestParam(value = "caId", required = false) BigDecimal caId,
			@RequestParam(value = "casId", required = false) BigDecimal casId,
			RedirectAttributes redirectAttributes) {
	
	
		//CrmActivityAd ad=new CrmActivityAd();
		CrmActivity activity=new CrmActivity();
		CrmActivitySteps step=new CrmActivitySteps();
		step.getCrmActivityActivitysManagers().add(m);
		activity.getCrmActivitySteps().add(step);
        step.setCrmActivity(activity);
		m.setCrmActivitySteps(step);
		m.setCrmActivity(activity);
		return super.create(model, m, result, redirectAttributes);
	}

}
