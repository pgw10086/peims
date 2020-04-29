package com.edu.peims.rest;

import com.edu.peims.exception.user.UserNotFoundException;
import com.edu.peims.model.WageInformation;
import com.edu.peims.service.PeimsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1/annualIncomes")
@Api("年工资")
public class AnnualIncomeRestController {
    @Autowired
    private PeimsService peimsService;

    @GetMapping("/{year}")
    @ApiOperation(value = "获取输入参数这一年的年收入")
    public ResponseEntity<Collection<WageInformation>> annualIncome(@PathVariable String year) {
        return new ResponseEntity<>(peimsService.findAllWageByYear(year), HttpStatus.OK);
    }

    @GetMapping("/{year}/{id}")
    @ApiOperation(value = "获取输入参数year这一年员工ID为id的员工的年收入")
    public ResponseEntity<Collection<WageInformation>> annualIncome(@PathVariable int id, @PathVariable String year)
            throws UserNotFoundException {
        Collection<WageInformation> wageInfo = new ArrayList<>();
        wageInfo.add(peimsService.findUserYearWage(id, year));
        return new ResponseEntity<>(wageInfo, HttpStatus.OK);
    }
}
