package in.co.sm.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import in.co.sm.dto.ShipmentDTO;
import in.co.sm.dto.TrackingDTO;
import in.co.sm.dto.UserDTO;

@Repository
public class TrackingDAOImpl implements TrackingDAOInt {

	private static Logger log = Logger.getLogger(TrackingDAOImpl.class.getName());

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<TrackingDTO> list() {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Override
	public List<TrackingDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("TrackingDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<TrackingDTO> query = session.createQuery("from TrackingDTO", TrackingDTO.class);
		List<TrackingDTO> list = query.getResultList();
		log.info("TrackingDAOImpl List method End");
		return list;
	}

	@Override
	public List<TrackingDTO> search(TrackingDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	@Override
	public List<TrackingDTO> search(TrackingDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("TrackingDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(TrackingDTO.class);
		
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			

			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("TrackingDAOImpl Search method End");
		return criteria.list();
	}

	@Override
	public Long add(TrackingDTO dto) {
		// TODO Auto-generated method stub
		log.info("TrackingDAOImpl add method started");
		Session session = entityManager.unwrap(Session.class);
		Long pk = (Long) session.save(dto);
		log.info("TrackingDAOImpl add method ended");
		return pk;
	}

	@Override
	public TrackingDTO findByShipmentId(Long id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(TrackingDTO.class);
		criteria.add(Restrictions.eq("shipmentId", id));
		TrackingDTO dto = (TrackingDTO) criteria.uniqueResult();
		return dto;
	}

	@Override
	public TrackingDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("TrackingDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		TrackingDTO dto = (TrackingDTO) session.get(TrackingDTO.class, pk);
		log.info("TrackingDAOImpl FindByPk method End");
		return dto;
	}

	@Override
	public void update(TrackingDTO dto) {
		// TODO Auto-generated method stub
		log.info("TrackingDAOImpl Update method Start");
		Session session = entityManager.unwrap(Session.class);
		session.merge(dto);
		log.info("TrackingDAOImpl update method End");
	}

	@Override
	public void delete(TrackingDTO dto) {
		// TODO Auto-generated method stub
		//entityManager.remove(entityManager.contains(dto) ? dto : entityManager.merge(dto));
		Session session = entityManager.unwrap(Session.class);
		 Query<TrackingDTO> q =	session.createNativeQuery("delete s_tracking ,s_shipment from s_tracking inner join s_shipment where s_tracking.shipmentid = s_shipment.id and s_tracking.id ="+dto.getId()+"");
		  q.executeUpdate();
		  System.out.println("executed!!");
	}
}
