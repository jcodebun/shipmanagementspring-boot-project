package in.co.sm.form;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import in.co.sm.dto.BaseDTO;
import in.co.sm.dto.ShipmentDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShipmentForm extends BaseForm {

	@NotEmpty(message = "Sender Name is required")
	private String senderName;
	@NotEmpty(message = "Sender Mobile No. is required")
	private String senderMobile;
	@NotEmpty(message = "Sender EmailId is required")
	private String senderEmail;
	@NotEmpty(message = "Sender Address is required")
	private String senderAddress;
	@NotEmpty(message = "Receiver Name is required")
	private String receiverName;
	@NotEmpty(message = "Receiver Mobile No. is required")
	private String receiverMobile;
	@NotEmpty(message = "Receiver EmailId is required")
	private String receiverEmail;
	@NotEmpty(message = "Receiver Address is required")
	private String receiverAddress;
	@NotEmpty(message = "Please enter details")
	private String shipmentDetails;
	@NotNull(message = "Weight is required")
	private Long shipmentWeight;
	
	private Long trackingId;
	@Override
	public BaseDTO getDTO() {
		// TODO Auto-generated method stub
		ShipmentDTO bean = new ShipmentDTO();
		bean.setId(id);
		bean.setSenderName(senderName);
		bean.setSenderMobile(senderMobile);
		bean.setSenderEmail(senderEmail);
		bean.setSenderAddress(senderAddress);
		bean.setReceiverName(receiverName);
		bean.setReceiverMobile(receiverMobile);
		bean.setReceiverEmail(receiverEmail);
		bean.setReceiverAddress(receiverAddress);
		bean.setTrackingId(trackingId);
		bean.setShipmentDetails(shipmentDetails);
		bean.setShipmentWeight(shipmentWeight);
		bean.setCreatedBy(createdBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedBy(modifiedBy);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		ShipmentDTO bean = (ShipmentDTO)bDto;
		id = bean.getId();
		senderName = bean.getSenderName();
		senderEmail = bean.getSenderEmail();
		senderMobile = bean.getSenderMobile();
		senderAddress = bean.getSenderAddress();
		receiverName = bean.getReceiverName();
		receiverEmail = bean.getReceiverEmail();
		receiverAddress = bean.getReceiverAddress();
		receiverMobile = bean.getReceiverMobile();
		shipmentDetails = bean.getShipmentDetails();
		shipmentWeight = bean.getShipmentWeight();
		createdBy = bean.getCreatedBy();
		modifiedBy = bean.getModifiedBy();
		createdDateTime = bean.getCreatedDatetime();
		modifiedDateTime = bean.getModifiedDatetime();
	}

}
