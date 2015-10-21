package com.daphne.es.crm.activities.web.controller;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

import javax.validation.Valid;

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
import com.daphne.es.crm.activities.entity.CrmActivitySteps;
import com.daphne.es.crm.activities.entity.CrmActivityVipScripts;
import com.daphne.es.crm.activities.entity.enums.StepsCategoryEnum;
import com.daphne.es.sys.permission.entity.Role;
import com.daphne.es.sys.permission.entity.RoleResourcePermission;
import com.google.common.collect.Sets;

@Controller
@RequestMapping(value = "/activities/activitysteps")
public class CrmActivityStepsController extends BaseCRUDController<CrmActivitySteps, BigDecimal> {

	public CrmActivityStepsController() {
		setResourceIdentity("activities:activitysteps");
	}

	@Override
	protected void setCommonData(Model model) {
		super.setCommonData(model);
		model.addAttribute("StepsCategory", StepsCategoryEnum.values());
	}

	@RequestMapping(value = "{caId}/create", method = RequestMethod.GET)
	public String createWithActivitysteps(Model model, @Valid @ModelAttribute("m") CrmActivitySteps m,
			BindingResult result, @RequestParam(value = "caId", required = false) BigDecimal caId,
			RedirectAttributes redirectAttributes) {
		if (permissionList != null) {
			this.permissionList.assertHasCreatePermission();
		}

		setCommonData(model);
		model.addAttribute(Constants.OP_NAME, "新增");
		if (!model.containsAttribute("m")) {

			model.addAttribute("m", new CrmActivitySteps(caId));
		}
		return viewName("editForm");
	}

	@RequestMapping(value = "{caId}/create", method = RequestMethod.POST)
	public String createWithCrmActivitySteps(Model model, @Valid @ModelAttribute("m") CrmActivitySteps m,
			BindingResult result, @RequestParam(value = "caId", required = false) BigDecimal caId,
			@RequestParam(value = "scripts", required = false) String scripts,
			@RequestParam(value = "controlRate", required = false) BigDecimal controlRate,
			RedirectAttributes redirectAttributes, CrmActivity c) {
		CrmActivityVipScripts script = new CrmActivityVipScripts(scripts, controlRate);
		CrmActivity crmActivity = new CrmActivity();
		m.setCrmActivity(crmActivity);
		m.setCrmActivityVipScripts(script);
		script.setCrmActivitySteps(m);
		script.setCrmActivity(crmActivity);
		return super.create(model, m, result, redirectAttributes);
	}

	private void fillCrmActivity(CrmActivitySteps crmActivitySteps, BigDecimal casId, BigDecimal caId) {

		new CrmActivitySteps(caId);

	}

}
