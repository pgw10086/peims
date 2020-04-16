package com.edu.peims.rest;

import com.edu.peims.Exception.TaxExecption.TaxNotFoundException;
import com.edu.peims.Exception.UserExecption.UserNotFoundException;
import com.edu.peims.model.ConfirmedInfo;
import com.edu.peims.model.Wage;
import com.edu.peims.model.WageInformation;
import com.edu.peims.repository.WageRepository;
import com.edu.peims.service.PeimsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1/staffWages")
@Api("工资")
public class WageRestController {

    @Autowired
    private PeimsService peimsService;

    @PostMapping("")
    @ApiOperation(value = "将确认的员工月工资放入数据库")
    public ResponseEntity<Wage> confirmMonthSalary(@RequestBody @Valid Wage wage) {
        return new ResponseEntity<>(peimsService.addWage(wage), HttpStatus.OK);
    }

    @GetMapping("/{year}/{month}")
    @ApiOperation(value = "查询所有员工已确认的月工资")
    public ResponseEntity<Collection<WageInformation>> getMonthSalaries(
            @PathVariable String year, @PathVariable String month) {
        String date = year + "-" + month;
        return new ResponseEntity<>(peimsService.findAllMonthWage(date), HttpStatus.OK);
    }

    @GetMapping("/{year}/{month}/{id}")
    @ApiOperation(value = "查询传入ID员工已确认的月工资")
    public ResponseEntity<Collection<WageInformation>> getMonthWage(
            @PathVariable String year, @PathVariable String month, @PathVariable int id) throws UserNotFoundException {
        String date = year + "-" + month;
        Collection<WageInformation> wageInfo = new ArrayList<>();
        wageInfo.add(peimsService.findMonthWageById(date, id));
        return new ResponseEntity<>(wageInfo, HttpStatus.OK);
    }

    @GetMapping("")
    @ApiOperation(value = "获取未进入数据库的员工工资信息")
    public ResponseEntity<ConfirmedInfo> getUnConfirmedMonthWage(
            @Param("year") String year, @Param("month") String month, @Param("id") int id)
            throws UserNotFoundException, TaxNotFoundException {
        String date = year + "-" + month;
        return new ResponseEntity<>(peimsService.getUnConfirmedMonthWage(id,date), HttpStatus.OK);
    }


}
