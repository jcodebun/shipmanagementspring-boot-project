package in.co.sm.dao;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.sm.dto.UpdateWeightCostDTO;
@Repository
public class UpdateWeightCostDAOImpl implements UpdateWeightCostDAOInt {
	
	private static Logger log = Logger.getLogger(UpdateWeightCostDAOImpl.class.getName());


	@Autowired
	private EntityManager entityManager;
	@Override
	public Long add(UpdateWeightCostDTO dto) {
		// TODO Auto-generated method stub
		log.info("UpdateWeightCostDAOImpl add method started");
		Session session = entityManager.unwrap(Session.class);
		Long pk = (Long) session.save(dto);
		log.info("UpdateWeightCostDAOImpl add method ended");
		return pk;
	}
	@Override
	public Long calculatePrice(Long weight) {
		// TODO Auto-generated method stub
		UpdateWeightCostDTO bean = null;
		Long cost1,cost2;
		Long basePrice = 0L;
		Session session = entityManager.unwrap(Session.class);
		Query<UpdateWeightCostDTO> query = session.createQuery("FROM UpdateWeightCostDTO ORDER BY ID DESC");
		List<UpdateWeightCostDTO> list = query.getResultList();
		Iterator<UpdateWeightCostDTO> itr = list.iterator();
		if(itr.hasNext()) {
			bean = itr.next();
			cost1 = bean.getCost1();
			cost2 = bean.getCost2();
			if(weight <= 100) {
				basePrice = cost1 * weight;
				System.out.println("bp "+basePrice);
			}else {
				basePrice = cost2 * weight;
				System.out.println("bp2 "+basePrice);
			}
			System.out.println("bean = "+bean.getCost1());
		}
		if(list.size()==0) {
			basePrice = 10L * weight; // set default 10
		}
		System.out.println("size = "+list.size());
		return basePrice;
	}
	@Override
	public UpdateWeightCostDTO getCosts() {
		// TODO Auto-generated method stub
		UpdateWeightCostDTO bean = null;
		Session session = entityManager.unwrap(Session.class);
		Query<UpdateWeightCostDTO> query = session.createQuery("FROM UpdateWeightCostDTO ORDER BY ID DESC");
		List<UpdateWeightCostDTO> list = query.getResultList();
		Iterator<UpdateWeightCostDTO> itr = list.iterator();
		if(itr.hasNext()) {
			bean = itr.next();
		}
		return bean;
	}

}
