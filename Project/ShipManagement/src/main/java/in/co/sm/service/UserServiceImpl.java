package in.co.sm.service;

import java.util.List;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.sm.dao.UserDAOInt;
import in.co.sm.dto.UserDTO;
import in.co.sm.exceptions.DuplicateRecordException;


@Service
public class UserServiceImpl implements UserServiceInt {

	private static Logger log = Logger.getLogger(UserServiceImpl.class.getName());

	@Autowired
	private UserDAOInt dao;
	@Override
	public UserDTO authentication(UserDTO dto) {
		// TODO Auto-generated method stub
		log.info("UserServiceImpl authentication started");
		dto = dao.authentication(dto);
		log.info("UserServiceImpl authentication ended");
		return dto;
	}
	@Override
	public Long addUser(UserDTO dto) throws DuplicateRecordException {
		log.info("UserServiceImpl Add method start");
		UserDTO existdto = dao.findByLogin(dto.getLogin());
		if (existdto != null)
			throw new DuplicateRecordException("Login id Already Exist");
		Long pk=dao.addUser(dto);
		log.info("UserServiceImpl Add method end");
		return pk;
	}
	@Override
	public UserDTO findByLogin(String login) {
		UserDTO dto=dao.findByLogin(login);
		return dto;
	}
	@Override
	public List<UserDTO> list() {
		// TODO Auto-generated method stub
		log.info("UserServiceImpl list method start");
		List<UserDTO> list=dao.list();
		log.info("UserServiceImpl list method end");
		return list;
	}
	@Override
	public List<UserDTO> list(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("UserServiceImpl list method start");
		List<UserDTO> list=dao.list(pageNo, pageSize);
		log.info("UserServiceImpl list method end");
		return list;
	}
	@Override
	public List<UserDTO> search(UserDTO dto) {
		// TODO Auto-generated method stub
		log.info("UserServiceImpl search method start");
		List<UserDTO> list=dao.search(dto);
		log.info("UserServiceImpl search method end");
		return list;
	}
	@Override
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		log.info("UserServiceImpl search method start");
		List<UserDTO> list=dao.search(dto, pageNo, pageSize);
		log.info("UserServiceImpl search method end");
		return list;
	}
	@Override
	@Transactional
	public void delete(UserDTO dto) {
		// TODO Auto-generated method stub
		dao.delete(dto);
	}
	@Override
	@Transactional
	public void update(UserDTO dto) {
		// TODO Auto-generated method stub
		dao.update(dto);
	}
	@Override
	public UserDTO findBypk(long pk) {
		// TODO Auto-generated method stub
		log.info("UserServiceImpl findBypk method start");
		UserDTO dto = dao.findBypk(pk);
		log.info("UserServiceImpl findBypk method end");
		return dto;
	}
	@Override
	@Transactional
	public boolean changePassword(Long id, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		log.info("UserServiceImpl changePassword method start");
		UserDTO dtoExist =  findBypk(id); 
		if (dtoExist != null && dtoExist.getPassword().equals(oldPassword)) {
				  dtoExist.setPassword(newPassword); 
				  dao.update(dtoExist);
				  log.info("UserServiceImpl  changePassword method end"); 
				  return true;
				  }else
				  {
					  log.info("UserServiceImpl changePassword method start");
		return false;
		
				  }
		
	}
}
