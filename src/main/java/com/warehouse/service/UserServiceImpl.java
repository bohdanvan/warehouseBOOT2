package com.warehouse.service;//
////package com.warehouse.service;
////
////
////import com.warehouse.model.User;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.stereotype.Service;
////import org.springframework.transaction.annotation.Transactional;
////
////@Service("userService")
////@Transactional
////public class UserServiceImpl implements UserService {
////
////    @Autowired
////    private UserRepository userRepository;
////
////    @Autowired
////    private PasswordEncoder passwordEncoder;
////
////
////    public void save(User user) {
////        user.setPassword(passwordEncoder.encode(user.getPassword()));
////        userRepository.save(user);
////    }
////
////    public User findById(long id) {
////        return userRepository.findOne(id);
////    }
////
////    public User findByLogin(String login) {
////        return userRepository.findByLogin(login);
////    }
////
////}
//
//package com.warehouse.service;
//
//
//import com.warehouse.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service("userService")
//@Transactional
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//    public void save(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }
//
//    public User findById(long id) {
//        return userRepository.findOne(id);
//    }
//
//    public User findByLogin(String login) {
//        return userRepository.findByLogin(login);
//    }
//
//}
//
