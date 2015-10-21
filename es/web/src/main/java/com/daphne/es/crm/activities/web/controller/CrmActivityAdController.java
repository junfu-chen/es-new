package com.daphne.es.crm.activities.web.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.ArrayUtils;
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
import com.daphne.es.common.entity.search.Searchable;
import com.daphne.es.common.web.controller.BaseCRUDController;
import com.daphne.es.crm.activities.entity.CrmActivity;
import com.daphne.es.crm.activities.entity.CrmActivityAd;
import com.daphne.es.crm.activities.entity.CrmActivitySteps;
import com.daphne.es.crm.activities.service.CrmActivityActivitysBcounterselectionService;
import com.daphne.es.crm.activities.service.CrmActivityService;
import com.daphne.es.crm.activities.service.CrmActivityStepsService;

@Controller
@RequestMapping(value = "/activities/adpush")
public class CrmActivityAdController extends BaseCRUDController<CrmActivityAd, BigDecimal> {

	@Autowired
	private CrmActivityActivitysBcounterselectionService crmActivityActivitysBcounterselectionService;
	
	@Autowired
	private CrmActivityService crmActivityService;
	
	@Autowired
	private CrmActivityStepsService crmActivityStepsService;

	public CrmActivityAdController() {
		setResourceIdentity("activities:adpush");
	}

	@Override
	protected void setCommonData(Model model) {
		Searchable searchable = Searchable.newSearchable();
		model.addAttribute("brandList",
				crmActivityActivitysBcounterselectionService.findAllWithNoPageNoSort(searchable));
	}

	@RequestMapping(value = "{caId}/{casId}/create", method = RequestMethod.GET)
	public String createWithCrmActivityAd(Model model, @Valid @ModelAttribute("m") CrmActivityAd m,
			BindingResult result, @RequestParam(value = "caId", required = false) BigDecimal caId,
			@RequestParam(value = "casId", required = false) BigDecimal casId, RedirectAttributes redirectAttributes,CrmActivity crmactivity) {
		if (permissionList != null) {
			this.permissionList.assertHasCreatePermission();
		}

		setCommonData(model);
		model.addAttribute(Constants.OP_NAME, "新增");
		if (!model.containsAttribute("m")) {
			CrmActivity crmActivity = crmActivityService.findOne(caId);
			model.addAttribute("m", new CrmActivityAd(crmActivity));
		}
		return viewName("editForm");
	}

	@RequestMapping(value = "{caId}/{casId}/create", method = RequestMethod.POST)
	public String createWithCrmActivitySteps(Model model, @Valid @ModelAttribute("m") CrmActivityAd m,
			BindingResult result, @RequestParam(value = "caId", required = false) BigDecimal caId,
			@RequestParam(value = "casId", required = false) BigDecimal casId,
			RedirectAttributes redirectAttributes) {
	
	
		//CrmActivityAd ad=new CrmActivityAd();
		CrmActivity activity=new CrmActivity();
		CrmActivitySteps step=new CrmActivitySteps();
		step.getCrmActivityAds().add(m);
		activity.getCrmActivitySteps().add(step);
        step.setCrmActivity(activity);
		m.setCrmActivitySteps(step);
		m.setCrmActivity(activity);
		return super.create(model, m, result, redirectAttributes);
	}

	private void fillCrmActivityAd(CrmActivitySteps crmActivitySteps, CrmActivityAd crmActivityAd) {

		// crmActivitySteps.addCrmActivityAd(new CrmActivityAd());

	}

}
