package in.co.sm.form;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import in.co.sm.dto.BaseDTO;
import in.co.sm.dto.ShipmentDTO;
import in.co.sm.dto.TrackingDTO;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class TrackingForm extends BaseForm {


	@NotEmpty(message = "Description is required")
	private String description;
	
	private ShipmentDTO shipmentDTO;
	
	private Long shipmentId;
	
	@Override
	public BaseDTO getDTO() {
		// TODO Auto-generated method stub
		TrackingDTO bean = new TrackingDTO();
		bean.setId(id);
		bean.setDescription(description);
		bean.setShipment(shipmentDTO);
		bean.setShipmentId(shipmentId);
		bean.setCreatedBy(createdBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedBy(modifiedBy);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		TrackingDTO bean = (TrackingDTO)bDto;
		id = bean.getId();
		
		description = bean.getDescription();
		shipmentDTO = bean.getShipment();
		shipmentId = bean.getShipmentId();
		createdBy = bean.getCreatedBy();
		modifiedBy = bean.getModifiedBy();
		createdDateTime = bean.getCreatedDatetime();
		modifiedDateTime = bean.getModifiedDatetime();
	}

}
