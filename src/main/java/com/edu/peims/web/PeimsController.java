package com.edu.peims.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PeimsController {
    @GetMapping("/positionWage")
    public String positionWage() {
        return "positionWage/positionWageList";
    }

    @GetMapping("/annualIncome")
    public String annualIncome() {
        return "annualIncome/annualIncomeList";
    }

    @GetMapping("/tax")
    public String tax() {
        return "tax/taxList";
    }

    @GetMapping("/monthWage")
    public String monthWage() {
        return "monthWage/monthWageList";
    }

    @GetMapping("/monthWageConfirm")
    public String www() {
        return "monthWage/monthWageConfirm";
    }
}
