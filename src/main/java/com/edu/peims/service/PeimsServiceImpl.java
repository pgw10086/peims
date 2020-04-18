package com.edu.peims.service;

import com.edu.peims.Exception.TaxException.TaxNotFoundException;
import com.edu.peims.Exception.UserException.UserNotFoundException;
import com.edu.peims.Exception.WageException.WageNotFoundException;
import com.edu.peims.model.*;
import com.edu.peims.repository.PositionRepository;
import com.edu.peims.repository.TaxRepository;
import com.edu.peims.repository.UserRepository;
import com.edu.peims.repository.WageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class PeimsServiceImpl implements PeimsService {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private WageRepository wageRepo;
    @Autowired
    private TaxRepository taxRepo;
    @Autowired
    private PositionRepository positionRepo;

    @Override
    public Collection<WageInformation> findAllWageByYear(String year) {
        Collection<WageInformation> yearWageInfos = new ArrayList<>();
        Iterable<User> users = userRepo.findAll();
        for (User user :
                users) {
            try {
                yearWageInfos.add(findUserYearWage(user.getUserId(), year));
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
        }
        return yearWageInfos;
    }

    @Override
    public WageInformation findUserYearWage(int id, String year) throws UserNotFoundException {
        User user = findUserById(id);
        Collection<Wage> monthWages = wageRepo.findByYear(year + "%", id);
        WageInformation wageInfo = new WageInformation();
        wageInfo.setId(id);
        wageInfo.setDate(year);
        wageInfo.setName(user.getName());
        float wages = 0;
        for (Wage wage :
                monthWages) {
            wages += wage.getWageMoney();
        }
        wageInfo.setSalary(wages);
        return wageInfo;
    }

    @Override
    public Collection<WageInformation> findAllMonthWage(String date) {
        Collection<Wage> monthWages = wageRepo.findMonthWage(date);
        Collection<WageInformation> wageInfos = new ArrayList<>();
        for (Wage wage :
                monthWages) {
            User user = null;
            try {
                user = findUserById(wage.getUserId());
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
            WageInformation wageInfo = new WageInformation();
            wageInfo.setId(user.getUserId());
            wageInfo.setName(user.getName());
            wageInfo.setDate(wage.getWageDate());
            wageInfo.setSalary(wage.getWageMoney());
            wageInfos.add(wageInfo);
        }
        return wageInfos;
    }

    @Override
    public WageInformation findMonthWageById(String date, int id)
            throws UserNotFoundException, WageNotFoundException {
        User user = findUserById(id);
        Wage wage = wageRepo.findMonthWageById(date, id);
        if (wage == null){
            throw new WageNotFoundException();
        }
        WageInformation wageInfo = new WageInformation();
        wageInfo.setId(wage.getUserId());
        wageInfo.setName(user.getName());
        wageInfo.setDate(wage.getWageDate());
        wageInfo.setSalary(wage.getWageMoney());
        return wageInfo;
    }

    @Override
    public Wage addWage(Wage wage) {
        System.out.println(wage.getUserId());
        System.out.println(wage.getWageDate());
        System.out.println(wage.getWageTax());
        System.out.println(wage.getWageMoney());
        System.out.println(wage.getWageAbsenteeism());
        System.out.println(wage.getWageMerits());
        System.out.println(wage.getWageSeniority());
        System.out.println(wage.getWagePosition());
        System.out.println("add");
        return wageRepo.save(wage);
    }

    @Override
    public Tax addTax(Tax tax) {
        return taxRepo.save(tax);
    }

    @Override
    public Tax updateTax(Tax tax) {
        return taxRepo.save(tax);
    }

    @Override
    public void deleteTax(int id) {
        taxRepo.deleteById(id);
    }

    @Override
    public Collection<Tax> findAllTax() {
        return (Collection<Tax>) taxRepo.findAll();
    }

    @Override
    public Collection<Tax> findTaxByEnd(float end) {
        return taxRepo.findTaxByEnd(end);
    }

    @Override
    public Collection<Tax> findTaxByStart(float start) {
        return taxRepo.findTaxByStart(start);
    }

    @Override
    public Collection<Tax> findTaxBy(float start, float end) {
        return taxRepo.findTaxBy(end, start);
    }

    @Override
    public Position updatePosition(Position position) {
        return positionRepo.save(position);
    }

    @Override
    public Collection<Position> findAllPosition() {
        return (Collection<Position>) positionRepo.findAll();
    }

    @Override
    public Collection<Position> findPositionByName(String name) {
        return positionRepo.findPositionByName("%" + name + "%");
    }

    @Override
    public Collection<Position> findPositionById(int id) {
        return positionRepo.findPositionById(id);
    }

    @Override
    public User findUserById(int id) throws UserNotFoundException {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException();
        } else {
            return user;
        }
    }

    @Override
    public ConfirmedInfo getUnConfirmedMonthWage(int id, String date)
            throws UserNotFoundException, TaxNotFoundException {
        //TODO
        User user = findUserById(id);
        Position position = findPositionById(user.getPostionId()).iterator().next();
        ConfirmedInfo confirmedInfo = new ConfirmedInfo();
        confirmedInfo.setId(user.getUserId());
        confirmedInfo.setSeniority(user.getSeniority());
        confirmedInfo.setName(user.getName());
        confirmedInfo.setPostId(user.getPostionId());
        confirmedInfo.setPostWage(position.getSalary());
        confirmedInfo.setAbsence(0);
        float wageTotal = confirmedInfo.getSeniority() * 10 + confirmedInfo.getPostWage()
                - confirmedInfo.getAbsence() * 10;
        confirmedInfo.setTax(findWageTax(wageTotal).getTaxRate());
        confirmedInfo.setDate(date);
        return confirmedInfo;
    }

    @Override
    public Tax findWageTax(float wage) throws TaxNotFoundException {
        Tax tax = taxRepo.findWageTax(wage);
        if (tax == null) {
            throw new TaxNotFoundException();
        } else {
            return tax;
        }
    }
}
