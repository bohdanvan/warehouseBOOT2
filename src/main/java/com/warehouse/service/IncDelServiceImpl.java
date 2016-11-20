package com.warehouse.service;

import com.warehouse.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 13.11.2016.
 */
@Service
public class IncDelServiceImpl implements IncDelService {

    @Autowired
    IncDelRepository incDelRepository;

    @Autowired
    LoggerRepository loggerRepository;

    @Autowired
    Logger logger;

    @Autowired
    UserRepository userRepository;


    @Override
    public void add(IncDel incDel) {

    }

    @Override
    public IncDel addIncDel(IncDel incDel) {


//get count delivery for user

        String number = getPrincipal() + "." + incDelRepository.count(); // TODO: 13.11.2016 Refactor 
        incDel.setNumber(number);

        incDel.setWarehouseID("USA"); // TODO: 17.10.2016  BAG REFACTOR

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy : HH-mm");
        incDel.setDate(sdf.format(new Date()));
//        Query query = em.
//                createQuery("Select MAX(i.id) from IncDel i");
//        long lastIdIncDel = (long) query.getSingleResult();
        String descript = "Delivery was recived to USA2 warehouse .Time is take";


        // FIXME: 17.11.2016  this is working code , comment just for test
//        List<Box> boxesList = new ArrayList<Box>();
//        int boxQtyInt = incDel.getBoxQty(); //
//
//        int countBox = 0;
//        for (int i = 1; i <= boxQtyInt; i++) {
//            countBox++;
//            Box box = new Box();
//            // sumWeight+=box.getWeight();
//            box.setIncDelJOIN(incDel);
//            box.setNumber(number + "/" + i);
//            box.setNumBoxInсDel(countBox);
//            box.setStatus("create"); // TODO: 18.10.2016  ReFaCToR  List <Create,Date> CREATER LOGGER
//            boxesList.add(box);
//        }
//
//        incDel.setBoxes(boxesList);
        
        
        
        

//        PrintLableService printDOC = new PrintLableService();
//        try {
//            printDOC.printLableVertical(boxesList);
//        } catch (IOException iex) {
//            iex.printStackTrace();
//        }

        incDel.addLog(new Logger("create", descript, incDel));
//        incDel.setUserJOIN(userRepository.findByLogin(getPrincipal())); // FIXME: 14.11.2016  BACK from /
        incDelRepository.save(incDel);

        return incDel;
    }

    @Override
    public void save(IncDel incDel) {

    }

    @Override
    public IncDel saveIncDel(IncDel incDel) {
        return null;
    }

    @Override
    public void delete(IncDel incDel) {

    }

    @Override
    public int delete(long id) {
        return 0;
    }

    @Override
    public IncDel findById(long id) {
        return null;
    }

    @Override
    public List<IncDel> findAll() {
        return null;
    }

    @Override
    public List<IncDel> findAll(int setMaxResult) {
        return null;
    }

    @Override
    public List<IncDel> findByPrincipal() {
        return null;
    }

    @Override
    public List<IncDel> findByPrincipal(int setMaxResult) {
        return null;
    }

    @Override
    public List<IncDel> findByPrincipal(String principal) {
        return null;
    }

    @Override
    public List<IncDel> findByPrincipal(String principal, int setMaxResult) {
        return null;
    }

    @Override
    public List<IncDel> listByPattern(String field, String pattern) {
        return null;
    }

    @Override
    public List<IncDel> listByPattern(String reqClass, String field, String pattern) {
        return null;
    }

    @Override
    public List<IncDel> listByPattern(String reqClass, String field, String pattern, int setMaxResult) {
        return null;
    }


    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }


}
