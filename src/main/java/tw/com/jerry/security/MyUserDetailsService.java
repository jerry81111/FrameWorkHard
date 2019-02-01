package tw.com.jerry.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import tw.com.jerry.constant.RoleConstant;
import tw.com.jerry.dao.impl.MemberDaoImpl;
import tw.com.jerry.entity.MemberEntity;

@Configuration
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	MemberDaoImpl memberDaoImpl;

//	@Autowired
//	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberEntity member = memberDaoImpl.findByAccount(username);
		if (null == member) {
			throw new UsernameNotFoundException(username);
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(RoleConstant.readDataBase(member.getRole())));
		return new User(member.getAccount(), member.getPassword(), authorities);

	}

}
