package in.co.sm.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "s_tracking")
@Setter
@Getter
public class TrackingDTO extends BaseDTO {

	@Column(name = "date")
	private Date date;
	@Column(name = "description", length = 255)
	private String description;
	@ManyToOne
	@JoinColumn(name = "shipmentid")
	private ShipmentDTO shipment;
	@Column(name = "shipment_id")
	private Long shipmentId;
	@Override
	public String getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
