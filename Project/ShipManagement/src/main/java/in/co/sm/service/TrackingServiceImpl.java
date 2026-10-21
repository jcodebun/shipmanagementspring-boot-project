package in.co.sm.service;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.co.sm.dao.TrackingDAOInt;
import in.co.sm.dto.TrackingDTO;
import in.co.sm.exceptions.DuplicateRecordException;

@Service
public class TrackingServiceImpl implements TrackingServiceInt {
	
	private static Logger log = Logger.getLogger(TrackingServiceImpl.class.getName());

	
	@Autowired
	private TrackingDAOInt dao;

	@Override
	public List<TrackingDTO> list() {
		// TODO Auto-generated method stub
		log.info("TrackingServiceImpl list method start");
		List<TrackingDTO> list=dao.list();
		log.info("TrackingServiceImpl list method end");
		return list;
	}

	@Override
	public List<TrackingDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("TrackingServiceImpl list method start");
		List<TrackingDTO> list=dao.list(pageNo, pageSize);
		log.info("TrackingServiceImpl list method end");
		return list;
	}

	@Override
	public List<TrackingDTO> search(TrackingDTO dto) {
		// TODO Auto-generated method stub
		log.info("TrackingServiceImpl search method start");
		List<TrackingDTO> list=dao.search(dto);
		log.info("TrackingServiceImpl search method end");
		return list;
	}

	@Override
	public List<TrackingDTO> search(TrackingDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("TrackingServiceImpl search method start");
		List<TrackingDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("TrackingServiceImpl search method end");
		return list;
	}

	@Override
	public Long add(TrackingDTO dto) throws DuplicateRecordException {
		// TODO Auto-generated method stub
		log.info("TrackingServiceImpl Add method start");
		TrackingDTO existdto = dao.findByShipmentId(dto.getShipmentId());
		if (existdto != null)
			throw new DuplicateRecordException("Already updated tracking number");
		Long pk=dao.add(dto);
		log.info("TrackingServiceImpl Add method end");
		return pk;
	}

	@Override
	public TrackingDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("TrackingServiceImpl findBypk method start");
		TrackingDTO dto = dao.findBypk(pk);
		log.info("TrackingServiceImpl findBypk method end");
		return dto;
	}

	@Override
	@Transactional
	public void update(TrackingDTO dto) {
		// TODO Auto-generated method stub
		dao.update(dto);
	}

	@Override
	@Transactional
	public void delete(TrackingDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}

}
