package in.co.sm.dao;

import java.util.List;

import in.co.sm.dto.ShipmentDTO;
import in.co.sm.dto.TrackingDTO;

public interface ShipmentDAOInt {

	Long addShipment(ShipmentDTO dto);
	
	public ShipmentDTO findBypk(long pk);

	public List<ShipmentDTO> list();

	public List<ShipmentDTO> list(int pageNo, int pageSize);

	public List<ShipmentDTO> search(ShipmentDTO dto);

	public List<ShipmentDTO> search(ShipmentDTO dto, int pageNo, int pageSize);

}
