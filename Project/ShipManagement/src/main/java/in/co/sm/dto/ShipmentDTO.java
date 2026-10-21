package in.co.sm.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import in.co.sm.util.StringPrefixedSequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "s_shipment")
@Setter
@Getter
public class ShipmentDTO extends BaseDTO {

	@Column(name = "sender_name", length = 255)
	private String senderName;
	@Column(name = "sender_mobile", length = 255)
	private String senderMobile;
	@Column(name = "sender_email", length = 255)
	private String senderEmail;
	@Column(name = "sender_addres", length = 255)
	private String senderAddress;
	@Column(name = "receiver_name", length = 255)
	private String receiverName;
	@Column(name = "receiver_mobile", length = 255)
	private String receiverMobile;
	@Column(name = "receiver_email", length = 255)
	private String receiverEmail;
	@Column(name = "receiver_address", length = 255)
	private String receiverAddress;
	@Column(name = "tracking_id", length = 255, unique = true, columnDefinition = "bigint default 1000000" )
	private Long trackingId;
	@OneToMany(
			mappedBy = "shipment",
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.EAGER
			)
	private List<TrackingDTO> trackings = new ArrayList<>(); 
	
	@Column(name = "user_id" , length = 255)
	private long userid;
	@Column(name = "shipment_detail", length = 455)
	private String shipmentDetails;
	@Column(name = "weight")
	private Long shipmentWeight;
	
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
