package in.co.sm.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.co.sm.dao.ShipmentDAOInt;
import in.co.sm.dto.ShipmentDTO;
import in.co.sm.dto.TrackingDTO;

@Service
public class ShipmentServiceImpl implements ShipmentServiceInt {

	private static Logger log = Logger.getLogger(ShipmentServiceImpl.class.getName());

	@Autowired
	private ShipmentDAOInt dao;
	
	@Override
	public Long addShipment(ShipmentDTO dto) {
		log.info("ShipmentServiceImpl Add method start");
		Long pk=dao.addShipment(dto);
		log.info("ShipmentServiceImpl Add method end");
		return pk;
	}

	@Override
	public Long generateTrackingNo() {
		return null;
	}

	@Override
	public List<ShipmentDTO> list() {
		// TODO Auto-generated method stub
		log.info("ShipmentServiceImpl list method start");
		List<ShipmentDTO> list=dao.list();
		log.info("ShipmentServiceImpl list method end");
		return list;
	}

	@Override
	public List<ShipmentDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("ShipmentServiceImpl list method start");
		List<ShipmentDTO> list=dao.list(pageNo, pageSize);
		log.info("ShipmentServiceImpl list method end");
		return list;
	}

	@Override
	public List<ShipmentDTO> search(ShipmentDTO dto) {
		// TODO Auto-generated method stub
		log.info("ShipmentServiceImpl search method start");
		List<ShipmentDTO> list=dao.search(dto);
		log.info("ShipmentServiceImpl search method end");
		return list;
	}

	@Override
	public List<ShipmentDTO> search(ShipmentDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("ShipmentServiceImpl search method start");
		List<ShipmentDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("ShipmentServiceImpl search method end");
		return list;
	}

	@Override
	public Long calculatePrice(Long weight) {
		// TODO Auto-generated method stub
		Long basePrice = 10L;
		if(weight <= 100) {
			basePrice =  basePrice * weight;
		}else {
			basePrice = weight * 20;
		}
		return basePrice;
	}

	@Override
	public ShipmentDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("ShipmentServiceImpl findBypk method start");
		ShipmentDTO dto = dao.findBypk(pk);
		log.info("ShipmentServiceImpl findBypk method end");
		return dto;
	}

}
