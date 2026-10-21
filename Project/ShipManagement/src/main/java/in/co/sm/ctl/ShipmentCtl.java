package in.co.sm.ctl;

import java.util.HashMap;
import java.util.List;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import in.co.sm.dto.ShipmentDTO;
import in.co.sm.dto.UserDTO;
import in.co.sm.exceptions.DuplicateRecordException;
import in.co.sm.form.LoginForm;
import in.co.sm.form.ShipmentForm;
import in.co.sm.form.UserRegistrationForm;
import in.co.sm.service.ShipmentServiceInt;
import in.co.sm.service.UpdateWeightCostServiceInt;

@Controller
public class ShipmentCtl extends BaseCtl {
	
	private Logger log = Logger.getLogger(ShipmentCtl.class.getName());
	
	protected static final String OP_PROCEED = "Proceed";


	@Autowired
	private ShipmentServiceInt shipmentService;
	@Autowired
	private UpdateWeightCostServiceInt costServiceInt;
	
	
	
	@GetMapping("/home/login/addshipment")
	public String display(@ModelAttribute("form") ShipmentForm form, HttpSession session, Model model) {
		log.info("ShipmentCtl display method start");
		log.info("SHipemntCtl display method End");
		return "addShipment";
	}
	@GetMapping("/home/login/addshipment/pay")
	public String displayPay(@ModelAttribute("form") ShipmentForm form, HttpSession session, Model model) {
		log.info("ShipmentCtl display method start");
		log.info("SHipemntCtl display method End");
		return "paymentPage";
	}
	
	
	
	@PostMapping("/home/login/addshipment")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") ShipmentForm form,
			BindingResult bindingResult, Model model, HttpServletRequest request, HttpSession session) {

		log.info("ShipmentCtl add-shipment submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/addshipment";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "addShipment";
		}
		if(OP_PROCEED.equalsIgnoreCase(form.getOperation())) {
			ShipmentDTO entity = (ShipmentDTO) populateDTO(form.getDTO(), request);
			UserDTO userDTO = (UserDTO) session.getAttribute("user");
			entity.setUserid(userDTO.getId());
			Long price = costServiceInt.calculatePrice(entity.getShipmentWeight());
			model.addAttribute("price", price);
			session.setAttribute("price", price);
			return "paymentPage";
		}			
			

		log.info("ShipmentCtl add-shipment submit method end");
		return "addShipment";
	}
	
	@PostMapping("/home/login/addshipment/pay")
	public String pay(@RequestParam String operation, @Valid @ModelAttribute("form") ShipmentForm form,
			BindingResult bindingResult, Model model, HttpServletRequest request, HttpSession session) {

		log.info("ShipmentCtl add-shipment pay method start");	
					
			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				ShipmentDTO entity = (ShipmentDTO) populateDTO(form.getDTO(), request);
				UserDTO userDTO = (UserDTO) session.getAttribute("user");
				entity.setUserid(userDTO.getId());
				shipmentService.addShipment(entity);
				model.addAttribute("success", "Thank you! Kindly Note your Tracking No: "+entity.getTrackingId()+" !!!!");
				session.getAttribute("price");
				System.out.println("form "+form.getReceiverAddress());
			}
		
		log.info("ShipmentCtl add-shipment pay method end");
		return "paymentPage";
	}
	
	@RequestMapping(value = "/home/login/shipments/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchNgoList(@ModelAttribute("form") ShipmentForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/shipments/search";
		}

		int pageNo = form.getPageNo();
		int pageSize = form.getPageSize();

		if (OP_NEXT.equals(operation)) {
			pageNo++;
		} else if (OP_PREVIOUS.equals(operation)) {
			pageNo--;
		} 

		pageNo = (pageNo < 1) ? 1 : pageNo;
		pageSize = (pageSize < 1) ? 10 : pageSize;

		if (OP_DELETE.equals(operation)) {
			pageNo = 1;
			if (form.getIds() != null) {
				for (long id : form.getIds()) {
					ShipmentDTO dto = new ShipmentDTO();
					dto.setId(id);
					//shipmentService.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		
		ShipmentDTO dto = (ShipmentDTO) form.getDTO();

	//	NgoDTO uDto = (NgoDTO) session.getAttribute("user");
	
		List<ShipmentDTO> list = shipmentService.search(dto, pageNo, pageSize);
		List<ShipmentDTO> totallist = shipmentService.search(dto);
		model.addAttribute("list", list);

		if (list.size() == 0 && !OP_DELETE.equalsIgnoreCase(operation)) {
			model.addAttribute("error", "Record not found");
		}

		int listsize = list.size();
		int total = totallist.size();
		int pageNoPageSize = pageNo * pageSize;

		form.setPageNo(pageNo);
		form.setPageSize(pageSize);
		model.addAttribute("pageNo", pageNo);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("listsize", listsize);
		model.addAttribute("total", total);
		model.addAttribute("pagenosize", pageNoPageSize);
		model.addAttribute("form", form);
		return "shipmentList";
	}
}
