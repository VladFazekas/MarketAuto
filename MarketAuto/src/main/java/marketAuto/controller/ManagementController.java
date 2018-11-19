package marketAuto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagementController {

	@RequestMapping(value = "/manage-products")
	public ModelAndView showManageProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Add Product");
		mv.addObject("userClickManageProd", true);	
		
		return mv;
	}
}
