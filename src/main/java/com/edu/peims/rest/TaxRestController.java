package com.edu.peims.rest;

import com.edu.peims.Exception.TaxException.TaxAddMemberException;
import com.edu.peims.model.Tax;
import com.edu.peims.model.Wage;
import com.edu.peims.model.WageInformation;
import com.edu.peims.service.PeimsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1/taxes")
@Api("工资")
public class TaxRestController {

    @Autowired
    private PeimsService peimsService;

    @GetMapping("")
    @ApiOperation(value = "查询税率", notes = "可以输入开始工资和结束工资，只输入开始工资，结果返回开始工资之后的所有税率；" +
            "只输入结束工资，返回结束工资之前的所有税率；都输入返回之间的所有税率，都不输入返回所有税率")
    public ResponseEntity<Collection<Tax>> queryTax(@RequestParam(name = "start", required = false) String start,
                                                    @RequestParam(name = "end", required = false) String end) {
        if (null == start && null == end) {
            return new ResponseEntity<>(peimsService.findAllTax(), HttpStatus.OK);
        } else if (null == start) {
            return new ResponseEntity<>(peimsService.findTaxByEnd(Float.parseFloat(end)), HttpStatus.OK);
        } else if (null == end) {
            return new ResponseEntity<>(peimsService.findTaxByStart(Float.parseFloat(start)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(peimsService.findTaxBy(Float.parseFloat(start),
                    Float.parseFloat(end)), HttpStatus.OK);
        }
    }

    @PostMapping("")
    @ApiOperation(value = "添加税率项")
    public ResponseEntity<Tax> addTax(@RequestBody @Valid Tax tax, BindingResult result) throws TaxAddMemberException {
        if (result.hasErrors()) {
            throw new TaxAddMemberException();
        } else {
            return new ResponseEntity<>(peimsService.addTax(tax), HttpStatus.OK);
        }
    }

    @PutMapping("")
    @ApiOperation(value = "更新税率项")
    public ResponseEntity<Tax> updateTax(@RequestBody @Valid Tax tax, BindingResult result) throws TaxAddMemberException {
        if (result.hasErrors()) {
            throw new TaxAddMemberException();
        } else {
            return new ResponseEntity<>(peimsService.updateTax(tax), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除税率项")
    public void delTax(@PathVariable int id) {
        peimsService.deleteTax(id);
    }
}
