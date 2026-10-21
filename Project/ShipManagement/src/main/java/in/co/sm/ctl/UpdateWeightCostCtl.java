package in.co.sm.ctl;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.sm.dto.ShipmentDTO;
import in.co.sm.dto.TrackingDTO;
import in.co.sm.dto.UpdateWeightCostDTO;
import in.co.sm.dto.UserDTO;
import in.co.sm.form.ShipmentForm;
import in.co.sm.form.UpdateWeightCostForm;
import in.co.sm.service.UpdateWeightCostServiceInt;

@Controller
public class UpdateWeightCostCtl extends BaseCtl {

	private Logger log = Logger.getLogger(UpdateWeightCostCtl.class.getName());
	
	@Autowired
	private UpdateWeightCostServiceInt updateWeightCostService;
	
	@GetMapping("/home/login/addcost")
	public String display(@ModelAttribute("form") UpdateWeightCostForm form, HttpSession session, Model model) {
		log.info("UpdateWeightCostCtl display method start");
		log.info("UpdateWeightCostCtl display method End");
		return "addCost";
	}
	
	@PostMapping("/home/login/addcost")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") UpdateWeightCostForm form,
			BindingResult bindingResult, Model model, HttpServletRequest request, HttpSession session) {

		log.info("UpdateWeightCostCtl add-cost submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/addcost";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "addCost";
		}
		if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
			UpdateWeightCostDTO entity = (UpdateWeightCostDTO) populateDTO(form.getDTO(), request);
				updateWeightCostService.add(entity);
				model.addAttribute("success", "Cost added successfully");
			
			return "addCost";
		}			

		log.info("UpdateWeightCostCtl add-cost submit method end");
		return "addCost";
	}
	
	@GetMapping("/home/login/viewcost")
	public String displayCost(@ModelAttribute("form") UpdateWeightCostForm form, HttpSession session, Model model) {
		log.info("UpdateWeightCostCtl displayCost method start");
		UpdateWeightCostDTO bean = new UpdateWeightCostDTO();
		 bean = updateWeightCostService.getCosts();
		 model.addAttribute("bean", bean);
		log.info("UpdateWeightCostCtl displayCost method End");
		return "costList";
	}

}
