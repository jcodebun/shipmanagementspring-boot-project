package in.co.sm.form;

import javax.validation.constraints.NotNull;

import in.co.sm.dto.BaseDTO;
import in.co.sm.dto.UpdateWeightCostDTO;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class UpdateWeightCostForm extends BaseForm {

	@NotNull(message = "Cost of Weight is required")
	private Long cost1;
	@NotNull(message = "Cost of Weight is required")
	private Long cost2;
	@Override
	public BaseDTO getDTO() {
		// TODO Auto-generated method stub
		UpdateWeightCostDTO bean = new UpdateWeightCostDTO();
		bean.setId(id);
		bean.setCost1(cost1);
		bean.setCost2(cost2);
		bean.setCreatedBy(createdBy);
		bean.setCreatedDatetime(createdDateTime);
		bean.setModifiedBy(modifiedBy);
		bean.setModifiedDatetime(modifiedDateTime);
		return bean;
	}

	@Override
	public void populate(BaseDTO bDto) {
		// TODO Auto-generated method stub
		UpdateWeightCostDTO bean = (UpdateWeightCostDTO)bDto;
		id = bean.getId();
		cost1 = bean.getCost1();
		cost2 = bean.getCost2();
		createdBy = bean.getCreatedBy();
		modifiedBy = bean.getModifiedBy();
		createdDateTime = bean.getCreatedDatetime();
		modifiedDateTime = bean.getModifiedDatetime();
	}

}
