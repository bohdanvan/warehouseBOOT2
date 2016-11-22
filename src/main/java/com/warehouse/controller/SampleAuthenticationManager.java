package com.warehouse.controller;

import com.warehouse.model.User;
import com.warehouse.model.UserRepository;
import com.warehouse.model.UserRole;
import com.warehouse.model.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 15.11.2016.
 */
public class SampleAuthenticationManager implements AuthenticationManager {
    static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRolesRepository userRoleRepository;
//    static {
//        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
////        AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//    }


    public Authentication authenticate(Authentication auth) throws AuthenticationException {


        User user = new User();
        List<UserRole> userRoleList = null;
        try {

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB_property_connection");
            EntityManager em = emf.createEntityManager();

            Query query = em.createQuery("SELECT u FROM User u WHERE u.userName = :login", User.class);
            query.setParameter("login", auth.getName());
            user = (User) query.getSingleResult();

            Query query1 = em.createQuery("SELECT ur FROM UserRole ur WHERE ur.userJOIN.userName = :login", UserRole.class);
            query1.setParameter("login", auth.getName());
            userRoleList = query1.getResultList();

            em.close();
            emf.close();

        } catch (NullPointerException nex) {
            System.out.println("login :" + auth.getName() + " was not found NullPointeEx");

        } catch (NoResultException nrex) {
            System.out.println("login :" + auth.getName() + " was not found NoResultEx");

        }

        if (auth.getName().equals(user.getUserName()) && (auth.getCredentials().equals(user.getPassword()))) {

            if (userRoleList.size() == 0) {
                System.out.println("userRoleList == null");
            }

            for (UserRole userRole : userRoleList
                    ) {
                System.out.println(userRole.getRole());
                AUTHORITIES.add(new SimpleGrantedAuthority(userRole.getRole()));
            }
            System.out.println("User " + user.getUserName() + " was authenticated. Roles qty : "+AUTHORITIES.size());

            return new UsernamePasswordAuthenticationToken(auth.getName(),
                    auth.getCredentials(), AUTHORITIES);
        }
        throw new BadCredentialsException("Bad Credentials");
    }
}




//
//try {
//    Long userId = userRepository.findByUserName(auth.getName()).getUserId(); // TODO: 16.11.2016  fixed BAG -  find ROLE
//    for (UserRole userRole : userRoleRepository.findAll()
//            ) {
//        if (userRole.getUserJOIN().equals(userId)) {
//            AUTHORITIES.add(new SimpleGrantedAuthority(userRole.getRole()));
//        }
//    }
//}catch (NullPointerException ex){
//    AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_NullPointerEx"));
//}
//        if (auth.getName().equals(auth.getCredentials())) {
//
//            return new UsernamePasswordAuthenticationToken(auth.getName(),
//                    auth.getCredentials(), AUTHORITIES);
//        }
//        throw new BadCredentialsException("Bad Credentials");
//    }
//}

