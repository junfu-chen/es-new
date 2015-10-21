package com.daphne.es.crm.activities.web.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daphne.es.common.Constants;
import com.daphne.es.common.web.controller.BaseCRUDController;
import com.daphne.es.crm.activities.entity.Bcounterselection;
import com.daphne.es.crm.activities.entity.CrmActivity;
import com.daphne.es.crm.activities.entity.CrmActivityCoupon;
import com.daphne.es.crm.activities.entity.CrmActivityCouponRule;
import com.daphne.es.crm.activities.entity.CrmActivitySteps;
import com.daphne.es.crm.activities.service.CrmActivityActivitysBcounterselectionService;
import com.daphne.es.sys.organization.entity.Job;
import com.daphne.es.sys.organization.entity.Organization;
import com.daphne.es.sys.permission.entity.Role;
import com.daphne.es.sys.permission.entity.RoleResourcePermission;
import com.google.common.collect.Sets;



@Controller
@RequestMapping(value = "/activities/coupon")
public class CrmActivityCouponController extends BaseCRUDController<CrmActivityCoupon, BigDecimal>{
	
	   @Autowired
	   private CrmActivityActivitysBcounterselectionService  CrmActivityActivitysBcounterselectionService;
	
	   public CrmActivityCouponController() {
	        setResourceIdentity("sys:coupon");
	       
	    }
	  @ModelAttribute(value="brands")
	  public List<Bcounterselection> getBcounterselection(){
		 return CrmActivityActivitysBcounterselectionService.findAll();
	  }
	
	@RequestMapping(value = "{casId}/{caId}/create", method = RequestMethod.GET)
	
	public String createCoupon(
            Model model,
            @PathVariable("caId") CrmActivity crmActivity,
            @PathVariable("casId") CrmActivitySteps crmActivitySteps) {
		// TODO Auto-generated method stub
		//model.addAttribute("brands", CrmActivityActivitysBcounterselectionService.findAll());
		if (permissionList != null) {
            this.permissionList.assertHasCreatePermission();
        }
		  //System.out.println(casId+"11111");

        setCommonData(model);
        model.addAttribute(Constants.OP_NAME, "新增");
        if (!model.containsAttribute("m")) {

        	CrmActivityCoupon crmActivityCoupon=new CrmActivityCoupon();
        	crmActivityCoupon.setCrmActivity(crmActivity);
        	crmActivityCoupon.setCrmActivitySteps(crmActivitySteps);
            model.addAttribute("m", crmActivityCoupon);   

        }
        //System.out.println("!!!!!!!!!!!!!!!!!");
        return viewName("editForm");
	}
	 @RequestMapping(value = "{casId}/{caId}/create", method = RequestMethod.POST)
	    public String createWithCouponRule(
	            Model model,
	            @Valid @ModelAttribute("m") CrmActivityCoupon crmActivityCoupon, BindingResult result,
	            @RequestParam("saleAmounts") BigDecimal[] saleAmounts,
	            @RequestParam("discountAmounts") BigDecimal[] discountAmounts,
	            @RequestParam("brands") String[] brands,
	            RedirectAttributes redirectAttributes) {

	        fillResourcePermission(crmActivityCoupon, saleAmounts, discountAmounts,brands);

	        //return super.create(model, crmActivityCoupon, result, redirectAttributes);
	        if (permissionList != null) {
	            this.permissionList.assertHasCreatePermission();
	        }

	        if (hasError(crmActivityCoupon, result)) {
	            return showCreateForm(model);
	        }
	        baseService.save(crmActivityCoupon);
	        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "新增成功");
	       return redirectToUrl("/activities/coupon/"+crmActivityCoupon.getId());
	       // return Request.getRequest(request);
	    }
	 @RequestMapping(value = "{id}/update/override", method = RequestMethod.POST)
		public String updateWithCouponRule(Model model,
	            @Valid @ModelAttribute("m") CrmActivityCoupon crmActivityCoupon, BindingResult result,
	            @RequestParam("saleAmounts") BigDecimal[] saleAmounts,
	            @RequestParam("discountAmounts") BigDecimal[] discountAmounts,
	            @RequestParam("brands") String[] brands,
				@RequestParam(value = Constants.BACK_URL, required = false) String backURL,
				RedirectAttributes redirectAttributes) {

		 fillResourcePermission(crmActivityCoupon, saleAmounts, discountAmounts,brands);

		  if (permissionList != null) {
	            this.permissionList.assertHasUpdatePermission();
	        }

	        if (hasError(crmActivityCoupon, result)) {
	            return showUpdateForm(crmActivityCoupon, model);
	        }
	        baseService.update(crmActivityCoupon);
	        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "修改成功");
	        System.out.println(crmActivityCoupon.getId()+"aaaaaaaaaaaa");
	        return redirectToUrl("/activities/coupon/"+crmActivityCoupon.getId());
		}
	  private void fillResourcePermission(CrmActivityCoupon crmActivityCoupon, BigDecimal[] saleAmounts,BigDecimal[] discountAmounts,String[] brands) {
	        int saleAmountLength = saleAmounts.length;
	        if (saleAmounts.length == 0) {
	            return;
	        }
	       
	            for (int i = 0; i < saleAmountLength; i++) {

	            	if(saleAmounts[i]!=null || discountAmounts[i]!=null || brands[i]!=null || !saleAmounts[i].equals("") || !discountAmounts[i].equals("") || !brands[i].equals(""))
	            	crmActivityCoupon.addCouponRule(
	                        new CrmActivityCouponRule(crmActivityCoupon.getCrmActivitySteps().getId(),crmActivityCoupon.getCrmActivity().getId(),saleAmounts[i],discountAmounts[i],brands[i] )
	                );

	            }
	        }

	   
}
