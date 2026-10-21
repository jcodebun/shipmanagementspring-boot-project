package in.co.sm.service;

import java.util.List;

import in.co.sm.dto.TrackingDTO;
import in.co.sm.exceptions.DuplicateRecordException;



public interface TrackingServiceInt {
	
	public Long add(TrackingDTO dto) throws DuplicateRecordException;
	
	public TrackingDTO findBypk(long pk);
	
	public void update(TrackingDTO dto);
	
	public void delete(TrackingDTO dto);

	public List<TrackingDTO> list();

	public List<TrackingDTO> list(int pageNo, int pageSize);

	public List<TrackingDTO> search(TrackingDTO dto);

	public List<TrackingDTO> search(TrackingDTO dto, int pageNo, int pageSize);
}
