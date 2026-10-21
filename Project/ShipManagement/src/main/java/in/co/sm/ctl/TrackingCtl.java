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
import in.co.sm.dto.TrackingDTO;
import in.co.sm.exceptions.DuplicateRecordException;
import in.co.sm.form.TrackingForm;
import in.co.sm.service.ShipmentServiceInt;
import in.co.sm.service.TrackingServiceInt;

@Controller
public class TrackingCtl extends BaseCtl {

	private Logger log = Logger.getLogger(TrackingCtl.class.getName());

	protected static final String OP_PROCEED = "Proceed";
	protected static final String OP_SEARCH = "Search";

	@Autowired
	private ShipmentServiceInt shipmentService;

	@Autowired
	private TrackingServiceInt trackingService;

	@ModelAttribute
	public void preload(Model model) {
		System.out.println("dd : " + shipmentService.search(null));
		model.addAttribute("trackingList", shipmentService.search(null));

	}

	@GetMapping("/home/login/addtracking")
	public String display(@RequestParam(required = false) Long id, Long pId, @ModelAttribute("form") TrackingForm form,
			HttpSession session, Model model) {
		log.info("TrackingCtl display method start");
		if (form.getId() > 0) {
			TrackingDTO bean = trackingService.findBypk(id);
			form.populate(bean);
		}
		log.info("TrackingCtl display method End");
		return "addTracking";
	}

	@PostMapping("/home/login/addtracking")
	public String submit(@RequestParam String operation, @Valid @ModelAttribute("form") TrackingForm form,
			BindingResult bindingResult, Model model, HttpServletRequest request, HttpSession session) {

		log.info("TrackingCtl add-tracking submit method start");

		if (OP_RESET.equalsIgnoreCase(form.getOperation())) {
			return "redirect:/home/login/addtracking";
		}

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return "addTracking";
		}
		try {

			if (OP_SAVE.equalsIgnoreCase(form.getOperation())) {
				TrackingDTO entity = (TrackingDTO) populateDTO(form.getDTO(), request);

				if (entity.getId() > 0) {
					entity.setShipment(shipmentService.findBypk(entity.getShipmentId()));
					trackingService.update(entity);
					model.addAttribute("success", "Tracking Details update Successfully!!!!");
				} else {
					entity.setShipment(shipmentService.findBypk(entity.getShipmentId()));
					trackingService.add(entity);
					model.addAttribute("success", "Tracking Details added successfully");
				}
				return "addTracking";
			}
		} catch (DuplicateRecordException e) {
			// TODO Auto-generated catch block
			model.addAttribute("error", e.getMessage());
			return "addTracking";
		}

		log.info("TrackingCtl add-tracking submit method end");
		return "";
	}

	@RequestMapping(value = "/home/login/trackshipment/search", method = { RequestMethod.GET, RequestMethod.POST })
	public String searchList(@ModelAttribute("form") TrackingForm form,
			@RequestParam(required = false) String operation, Long vid, HttpSession session, Model model) {

		if (OP_RESET.equalsIgnoreCase(operation)) {
			return "redirect:/home/login/trackshipment/search";
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
					TrackingDTO dto = new TrackingDTO();
					dto.setId(id);
					trackingService.delete(dto);
				}
				model.addAttribute("success", "Deleted Successfully!!!");
			} else {
				model.addAttribute("error", "Select at least one record");
			}
		}
		
		TrackingDTO dto = (TrackingDTO) form.getDTO();
		List<TrackingDTO> list = trackingService.search(dto, pageNo, pageSize);
		List<TrackingDTO> totallist = trackingService.search(dto);
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
		return "trackList";
	}
}
