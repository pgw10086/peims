package com.edu.peims.rest;

import com.edu.peims.exception.type.TypeException;
import com.edu.peims.model.Position;
import com.edu.peims.service.PeimsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/position")
public class PositionRestController {

    @Autowired
    PeimsService peimsService;

    @GetMapping("")
    @ApiOperation(value = "查询职位工资")
    public Iterable<Position> queryPostSalary(@RequestParam(name = "id", required = false) String id,
                                              @RequestParam(name = "name", required = false) String name) {
        if (null == id && null == name) {
            return peimsService.findAllPosition();
        } else if (null == id) {
            return peimsService.findPositionByName(name);
        } else if (null == name) {
            return peimsService.findPositionById(Integer.parseInt(id));
        } else {
            return null;
        }
    }

    @PutMapping("")
    @ApiOperation(value = "更改职位工资")
    public ResponseEntity<Position> updatePostSalary(@RequestBody @Valid Position position, BindingResult result) throws TypeException {
        if (result.hasErrors()){
            throw new TypeException();
        }
        return new ResponseEntity<>(peimsService.updatePosition(position), HttpStatus.OK);
    }
}
