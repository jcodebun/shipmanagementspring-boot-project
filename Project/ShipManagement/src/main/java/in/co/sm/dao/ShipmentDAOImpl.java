package in.co.sm.dao;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import in.co.sm.dto.ShipmentDTO;
import in.co.sm.dto.TrackingDTO;

@Repository
public class ShipmentDAOImpl implements ShipmentDAOInt {

	private static Logger log = Logger.getLogger(ShipmentDAOImpl.class.getName());

	private static AtomicLong numberGenerator = new AtomicLong(810000000L);

	private static Long track = 10000000L;

	@Autowired
	private EntityManager entityManager;

	@Override
	public Long addShipment(ShipmentDTO dto) {
		log.info("ShipmentDAOImpl addShipment method started");
		Session session = entityManager.unwrap(Session.class);
		System.out.println("trackid is :" + dto.getId());

		Long updateTrack = track + nextPk();
		dto.setTrackingId(updateTrack);
		Long pk = (Long) session.save(dto);
		log.info("ShipmentDAOImpl addShipment method ended");
		return updateTrack;
	}

	public Long nextPk() {
		Long pk = 0L;
		Session session = entityManager.unwrap(Session.class);
		String sql = "SELECT MAX(id) FROM ShipmentDTO";
		Query<ShipmentDTO> query = session.createQuery(sql);
		Object a = query.getSingleResult();
		System.out.println("a "+a);
		if(a==null) {
			pk = 0L;
		}else {
			pk = (Long) a;
		}
		//System.out.println("a "+a.getId());
		System.out.println("pk " + pk);
		return pk + 1;

	}

	@Override
	public List<ShipmentDTO> list() {
		// TODO Auto-generated method stub
		return list(0, 0);
	}

	@Override
	public List<ShipmentDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("ShipmentDAOImpl List method Start");
		Session session = entityManager.unwrap(Session.class);
		Query<ShipmentDTO> query = session.createQuery("from ShipmentDTO", ShipmentDTO.class);
		List<ShipmentDTO> list = query.getResultList();
		log.info("ShipmentDAOImpl List method End");
		return list;
	}

	@Override
	public List<ShipmentDTO> search(ShipmentDTO dto) {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	@Override
	public List<ShipmentDTO> search(ShipmentDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("ShipmentDAOImpl Search method Start");
		Session session = entityManager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(ShipmentDTO.class);
		if (dto != null) {
			if (dto.getId() > 0) {
				criteria.add(Restrictions.eq("id", dto.getId()));
			}
			if (dto.getSenderName() != null && dto.getSenderName().length() > 0) {
				criteria.add(Restrictions.like("senderName", dto.getSenderName() + "%"));
			}
			if (dto.getReceiverName() != null && dto.getReceiverName().length() > 0) {
				criteria.add(Restrictions.like("receiverName", dto.getReceiverName() + "%"));
			}

			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult((int) pageNo);
				criteria.setMaxResults(pageSize);
			}
		}
		log.info("ShipmentDAOImpl Search method End");
		return criteria.list();
	}

	@Override
	public ShipmentDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("ShipmentDAOImpl FindByPk method Start");
		Session session = entityManager.unwrap(Session.class);
		ShipmentDTO dto = (ShipmentDTO) session.get(ShipmentDTO.class, pk);
		log.info("ShipmentDAOImpl FindByPk method End");
		return dto;
	}

	

}
