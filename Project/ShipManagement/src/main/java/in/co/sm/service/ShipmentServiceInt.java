package in.co.sm.service;

import java.util.List;

import in.co.sm.dto.ShipmentDTO;

public interface ShipmentServiceInt {
	
	Long addShipment(ShipmentDTO dto);
	
	public ShipmentDTO findBypk(long pk) ;
	
	Long generateTrackingNo();
	
	public List<ShipmentDTO> list();

	public List<ShipmentDTO> list(int pageNo, int pageSize);

	public List<ShipmentDTO> search(ShipmentDTO dto);

	public List<ShipmentDTO> search(ShipmentDTO dto, int pageNo, int pageSize);

	public Long calculatePrice(Long weight);
}
