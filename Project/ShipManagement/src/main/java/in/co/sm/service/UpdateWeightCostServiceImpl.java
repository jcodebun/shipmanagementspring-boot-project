package in.co.sm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.sm.dao.UpdateWeightCostDAOInt;
import in.co.sm.dto.UpdateWeightCostDTO;
@Service
public class UpdateWeightCostServiceImpl implements UpdateWeightCostServiceInt {

	@Autowired
	private UpdateWeightCostDAOInt dao;
	@Override
	public Long add(UpdateWeightCostDTO dto) {
		// TODO Auto-generated method stub
		Long pk = dao.add(dto);
		return pk;
	}
	@Override
	public Long calculatePrice(Long weight) {
		// TODO Auto-generated method stub
		Long pk = dao.calculatePrice(weight);
		return pk;
	}
	@Override
	public UpdateWeightCostDTO getCosts() {
		// TODO Auto-generated method stub
		UpdateWeightCostDTO bean = dao.getCosts();
		return bean;
	}

}
