package in.co.sm.service;

import in.co.sm.dto.UpdateWeightCostDTO;

public interface UpdateWeightCostServiceInt {

	Long add(UpdateWeightCostDTO dto);
	
	Long calculatePrice(Long weight);
	
	UpdateWeightCostDTO getCosts();
}
