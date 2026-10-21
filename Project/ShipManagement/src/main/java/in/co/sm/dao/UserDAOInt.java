package in.co.sm.dao;

import java.util.List;


import in.co.sm.dto.UserDTO;

public interface UserDAOInt {

	UserDTO authentication(UserDTO dto);
	
	Long addUser(UserDTO dto);
	
	void delete(UserDTO dto);
	
	void update(UserDTO dto);
	
	UserDTO findBypk(long pk);
	
	UserDTO findByLogin(String login);
	
	public List<UserDTO> list();

	public List<UserDTO> list(int pageNo, int pageSize);

	public List<UserDTO> search(UserDTO dto);

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize);
}
