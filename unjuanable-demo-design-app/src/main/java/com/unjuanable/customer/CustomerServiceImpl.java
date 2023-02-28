package com.unjuanable.customer;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.unjuanable.api.CustomerServiceI;
import com.unjuanable.customer.executor.CustomerAddCmdExe;
import com.unjuanable.customer.executor.query.CustomerListByNameQryExe;
import com.unjuanable.dto.CustomerAddCmd;
import com.unjuanable.dto.CustomerListByNameQry;
import com.unjuanable.dto.data.CustomerDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
@CatchAndLog
public class CustomerServiceImpl implements CustomerServiceI {

    @Resource
    private CustomerAddCmdExe customerAddCmdExe;

    @Resource
    private CustomerListByNameQryExe customerListByNameQryExe;

    public Response addCustomer(CustomerAddCmd customerAddCmd) {
        return customerAddCmdExe.execute(customerAddCmd);
    }

    @Override
    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry) {
        return customerListByNameQryExe.execute(customerListByNameQry);
    }

}