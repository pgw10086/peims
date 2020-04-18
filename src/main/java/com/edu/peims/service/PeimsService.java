package com.edu.peims.service;

import com.edu.peims.Exception.TaxException.TaxNotFoundException;
import com.edu.peims.Exception.UserException.UserNotFoundException;
import com.edu.peims.Exception.WageException.WageNotFoundException;
import com.edu.peims.model.*;

import java.util.Collection;

public interface PeimsService {
    public Collection<WageInformation> findAllWageByYear(String year);
    public WageInformation findUserYearWage(int id, String year) throws UserNotFoundException;
    public Collection<WageInformation> findAllMonthWage(String date);
    public WageInformation findMonthWageById(String date,int id) throws UserNotFoundException, WageNotFoundException;
    public Wage addWage(Wage wage);
    public Tax addTax(Tax tax);
    public Tax updateTax(Tax tax);
    public void deleteTax(int id);
    public Collection<Tax> findAllTax();
    public Collection<Tax> findTaxByEnd(float end);
    public Collection<Tax> findTaxByStart(float start);
    public Collection<Tax> findTaxBy(float start,float end);
    public Position updatePosition(Position position);
    public Collection<Position> findAllPosition();
    public Collection<Position> findPositionByName(String name);
    public Collection<Position> findPositionById(int id);
    public User findUserById(int id) throws UserNotFoundException;
    public ConfirmedInfo getUnConfirmedMonthWage(int id,String date) throws UserNotFoundException, TaxNotFoundException;
    public Tax findWageTax(float wage) throws TaxNotFoundException;
}
