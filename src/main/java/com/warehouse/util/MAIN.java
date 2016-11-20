//package com.warehouse.util;
//
//import com.warehouse.model.User;
//import com.warehouse.model.UserRole;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.persistence.*;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by user on 14.11.2016.
// */
//public class MAIN {
//
//
////    AuthenticationManager
//
//
//    private static AuthenticationManager am = new SampleAuthenticationManager();
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//        Logger log = LoggerFactory.getLogger(MAIN.class);
//        log.debug("Authenticating {}", "================================================================");
//        while (true) {
//
//
//            System.out.println("Please enter your username:");
//            String login = in.readLine();
//            System.out.println("Please enter your password:");
//            String password = in.readLine();
//
//            try {
//                Authentication request = new UsernamePasswordAuthenticationToken(login, password);
//                Authentication result = am.authenticate(request);
//                SecurityContextHolder.getContext().setAuthentication(result);
//                log.debug("Authenticating {}", request.getCredentials().toString());
////
//                System.out.println("result getPrincipal firstBlock "+result.getPrincipal().toString());
//                System.out.println("result getCredentials firstBlock "+result.getCredentials().toString());
//
//                break;
//
//            } catch (AuthenticationException e) {
//                System.out.println("Authentication failed: " + e.getMessage());
//            }
//        }
//
//        System.out.println("Successfully authenticated. Security context contains: " +
//                SecurityContextHolder.getContext().getAuthentication());
//    }
//}
//
//
//class SampleAuthenticationManager implements AuthenticationManager {
//    static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
//
//
//    public Authentication authenticate(Authentication auth) throws AuthenticationException {
//
//
//        User user = new User();
//        List<UserRole> userRoleList = null;
//        try {
//            EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB_property_connection");
//            EntityManager em = emf.createEntityManager();
//            Query query = em.createQuery("SELECT u FROM User u WHERE u.userName = :login", User.class);
//            query.setParameter("login", auth.getName());
//            user = (User) query.getSingleResult();
//
////            em.getTransaction().begin();
////
////            User user1 = new User();
////            user1.setUserName("make");
////            user1.setPassword("make");
////            user1.setEnabled(true);
////            user1.addRole("ROLE_ADMIN");
////            user1.addRole("USER");
////
////            em.persist(user1);
//
//
////            UserRole userRole = new UserRole();
////            userRole.setRole("ROLE_ADMIN");
////            userRole.setUserJOIN(user1);
////            em.persist(userRole);
//
////            em.getTransaction().commit();
//
////
////
//
////            System.out.println("id  :" + user.getUserName());
////            System.out.println("login succesfull :" + user.getUserName());
////            System.out.println("pass :" + user.getPassword());
////            System.out.println("listUserRole size :" + user.getUserRolesList().size());
////
////            System.out.println("====================================");
////            System.out.println("Size userRoleList " + userRoleList.size());
////            System.out.println("auth getName is:" + auth.getName());
////            System.out.println("auth getPrincipal is:" + auth.getPrincipal());
////            System.out.println("auth getCredentials is :" + auth.getCredentials());
//
//
//
//            Query query1 = em.createQuery("SELECT ur FROM UserRole ur WHERE ur.userJOIN.userName = :login", UserRole.class);
//            query1.setParameter("login", auth.getName());
//            userRoleList = query1.getResultList();
//
//
//        } catch (NullPointerException nex) {
//            System.out.println("login :" + auth.getName() + " was not found NullPointeEx");
//
//        } catch (NoResultException nrex) {
//            System.out.println("login :" + auth.getName() + " was not found NoResultEx");
//
//        }
//
//
//        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
//
//
////
////        for (UserRole userRole : user.getUserRolesList()
////                ) {
//////            System.out.println(userRole.getRole());
////
////        }
//
//
//
//        if (auth.getName().equals(user.getUserName()) && (auth.getCredentials().equals(user.getPassword()))) {
//            System.out.println("User " + user.getUserName() + " was registred");
//
//
//            if (userRoleList.size() == 0) {
//                System.out.println("userRoleList == null");
//            }
//
//            for (UserRole userRole : userRoleList
//                    ) {
//                System.out.println(userRole.getRole());
//                AUTHORITIES.add(new SimpleGrantedAuthority(userRole.getRole()));
//            }
//
//            return new UsernamePasswordAuthenticationToken(auth.getName(),
//                    auth.getCredentials(), AUTHORITIES);
//        }
//        throw new BadCredentialsException("Bad Credentials");
//    }
//}
//
//
////
////    public static void main(String[] args) {
//////       BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//////        System.out.println(passwordEncoder.encode("maki"));
////
////        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB_property_connection");
////        EntityManager em = emf.createEntityManager();
////
////        em.getTransaction().begin();
////
////        User user = new User();
////        user.setUserName("makena");
////        user.setEmail("email@email.com");
////        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // FIXME: 14.11.2016  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
////        user.setPassword(passwordEncoder.encode("makena"));
////        user.setEnabled(true);
////        em.persist(user);
////
////        UserRole userRole = new UserRole();
////        userRole.setRole("ROLE_USER");
////        userRole.setUserid(user);
////        em.persist(userRole);
////
////        UserRole userRoleAdmin = new UserRole();
////        userRoleAdmin.setRole("ROLE_ADMIN");
////        userRoleAdmin.setUserid(user);
////        em.persist(userRoleAdmin);
////
////
////        em.getTransaction().commit();
////    }}
//
//
//
//
////        $2a$10$ixGDlgzhmXfqzwbAlubNlO2cwIcdF/El4ujodjGLVkz/GwLgVIJg6
////        $2a$10$rkx8dnegazJLJVyJRdTnbu1o6i/y75ZMc4QsxkuvU0LC89EolLCt.
////        $2a$10$3XFSWAqo5mGKXfR3IDpf1OVcd8/gwDok1T/KICCisNX6XocLE83MK
//
