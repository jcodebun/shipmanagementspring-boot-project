package in.co.sm.service;

import java.util.List;
import in.co.sm.dto.UserDTO;
import in.co.sm.exceptions.DuplicateRecordException;

public interface UserServiceInt {

	UserDTO authentication(UserDTO dto);

	Long addUser(UserDTO dto) throws DuplicateRecordException;
	
	void delete(UserDTO dto);
	
	void update(UserDTO dto);

	List<UserDTO> list();

	List<UserDTO> list(int pageNo, int pageSize);

    List<UserDTO> search(UserDTO dto);
    
    UserDTO findBypk(long pk);

	List<UserDTO> search(UserDTO dto, int pageNo, int pageSize);

	UserDTO findByLogin(String login);
	
	boolean changePassword(Long id, String oldPassword, String newPassword);

}
