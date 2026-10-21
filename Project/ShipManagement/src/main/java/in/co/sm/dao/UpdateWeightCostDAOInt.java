package in.co.sm.dao;

import java.util.List;

import in.co.sm.dto.UpdateWeightCostDTO;

public interface UpdateWeightCostDAOInt {

	Long add(UpdateWeightCostDTO dto);
	
	Long calculatePrice(Long weight);
	
	UpdateWeightCostDTO getCosts();
}
