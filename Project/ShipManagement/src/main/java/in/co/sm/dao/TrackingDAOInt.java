package in.co.sm.dao;

import java.util.List;


import in.co.sm.dto.TrackingDTO;



public interface TrackingDAOInt {
	
	Long add(TrackingDTO dto);
	
	TrackingDTO findByShipmentId(Long id);
	
	public void delete(TrackingDTO dto);
	
	public TrackingDTO findBypk(long pk);

	public List<TrackingDTO> list();

	public List<TrackingDTO> list(int pageNo, int pageSize);

	public List<TrackingDTO> search(TrackingDTO dto);

	public List<TrackingDTO> search(TrackingDTO dto, int pageNo, int pageSize);

	public void update(TrackingDTO dto);
}
