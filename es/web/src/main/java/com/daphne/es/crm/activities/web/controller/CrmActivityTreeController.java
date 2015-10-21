package com.daphne.es.crm.activities.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daphne.es.common.Constants;
import com.daphne.es.common.plugin.web.controller.BaseTreeableController;
import com.daphne.es.crm.activities.entity.CrmActivityTree;


@Controller
@RequestMapping(value = "/activities/tree")
public class CrmActivityTreeController extends BaseTreeableController<CrmActivityTree, Long> {

	
	
	 public CrmActivityTreeController() {
	        setResourceIdentity("activities:tree");
	    }

	    @RequestMapping(value = "/changeStatus/{newStatus}")
	    public String changeStatus(
	            HttpServletRequest request,
	            @PathVariable("newStatus") Boolean newStatus,
	            @RequestParam("ids") Long[] ids,
	            RedirectAttributes redirectAttributes
	    ) {


	        this.permissionList.assertHasUpdatePermission();

	        for (Long id : ids) {
	        	CrmActivityTree tree = baseService.findOne(id);
	            tree.setShow(newStatus);
	            baseService.update(tree);
	        }
	        redirectAttributes.addFlashAttribute(Constants.MESSAGE, "操作成功！");

	        return "redirect:" + request.getAttribute(Constants.BACK_URL);
	    }

}
