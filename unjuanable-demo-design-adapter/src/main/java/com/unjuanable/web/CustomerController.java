package com.unjuanable.web;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.unjuanable.api.CustomerServiceI;
import com.unjuanable.common.logger.ExceptionHandleAnno;
import com.unjuanable.common.logger.InvokeRecordAnno;
import com.unjuanable.dto.CustomerAddCmd;
import com.unjuanable.dto.CustomerListByNameQry;
import com.unjuanable.dto.data.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CatchAndLog
@RestController
public class CustomerController {

    @Autowired
    private CustomerServiceI customerService;


    @ExceptionHandleAnno
    @InvokeRecordAnno("测试代理模式")
    @GetMapping("test")
    public Map<String, Object> testProxy(@RequestParam String biz,
                                         @RequestParam String param) {
        if (biz.equals("abc")) {
            throw new IllegalArgumentException("非法的 biz=" + biz);
        }
        Map<String, Object> result = new HashMap<>(4);
        result.put("id", 123);
        result.put("name", "小明");
        return result;
    }


    @GetMapping("testCatchAndLog")
    public Map<String, Object> testCatchAndLog(@RequestParam String biz,
                                               @RequestParam String param) {
        if (biz.equals("abc")) {
            throw new IllegalArgumentException("非法的 biz=" + biz);
        }
        Map<String, Object> result = new HashMap<>(4);
        result.put("id", 123);
        result.put("name", "小明");
        return result;
    }


    @GetMapping(value = "/helloworld")
    public String helloWorld() {
        return "Hello, welcome to COLA world!";
    }

    @GetMapping(value = "/customer")
    public MultiResponse<CustomerDTO> listCustomerByName(@RequestParam(required = false) String name) {
        CustomerListByNameQry customerListByNameQry = new CustomerListByNameQry();
        customerListByNameQry.setName(name);
        return customerService.listByName(customerListByNameQry);
    }

    @PostMapping(value = "/customer")
    public Response addCustomer(@RequestBody CustomerAddCmd customerAddCmd) {
        return customerService.addCustomer(customerAddCmd);
    }
}
