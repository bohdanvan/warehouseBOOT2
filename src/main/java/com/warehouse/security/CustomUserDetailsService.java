package com.warehouse.security;


import com.warehouse.model.User;
import com.warehouse.model.UserRepository;
import com.warehouse.model.UserRole;
import com.warehouse.model.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    /*
    private final UserRepository userRepository;
	private final UserRolesRepository userRolesRepository;
	*/

	// FIXME: 16.11.2016  проверить @Authowired  в оригинале по другому
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserRolesRepository userRolesRepository;


	@Autowired
    public CustomUserDetailsService(UserRepository userRepository,UserRolesRepository userRolesRepository) {
        this.userRepository = userRepository;
        this.userRolesRepository=userRolesRepository;
    }


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByUserName(username);
		if(null == user){
			throw new UsernameNotFoundException("No user present with username: "+username);
		}else{
			List<String> userRoles=userRolesRepository.findRoleByUserid(username);
			return new CustomUserDetails(user,userRoles);
		}
	}
        
	/*@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

			User user=userRepository.findByUserName(username);

		if(null == user){
			throw new UsernameNotFoundException("No user present with username: "+username);
		}else{
//			List<String> userRoles=userRolesRepository.findRoleByUserName(username);
//			List<Role> userRoles=userRolesRepository.findRoleByUserName(username);
			List<String> userRoles = null;
			for (UserRole role: userRolesRepository.findAll()
				 ) {
				userRoles.add(role.getRole());
				if((role.getUserJOIN().getUserName()).equals(username))
				userRoles.add(role.getRole());
			}

			return new CustomUserDetails(user,userRoles);
		}
	}
		*/





} /*/////////////////////////////////////////////////////////////////////////*/
