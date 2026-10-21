package in.co.sm.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "s_updatecost")
@Setter
@Getter
public class UpdateWeightCostDTO extends BaseDTO {

	@Column(name = "cost_1")
	private long cost1;
	@Column(name = "cost_2")
	private long cost2;
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
