package com.vedatkocyigit.Calculator.controller;

import com.vedatkocyigit.Calculator.dto.MultiplyRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    @GetMapping("/sum")
    public Double sum(@RequestParam(required = true) Double value1,@RequestParam(required = true) Double value2){

        return value1+value2;
    }

    @PostMapping("/multiply")
    public Double multiply(@RequestBody MultiplyRequest request){

        Double val1 = request.getValue1() != null ? request.getValue1() : 0.0;
        Double val2 = request.getValue2() != null ? request.getValue2() : 0.0;

        return val1 * val2;
    }
}
