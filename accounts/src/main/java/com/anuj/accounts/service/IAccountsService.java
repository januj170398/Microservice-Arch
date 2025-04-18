package com.anuj.accounts.service;

import com.anuj.accounts.dto.CustomerDto;

public interface IAccountsService {
    //@param customerDto - CustomerDto Object
    void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccountDetails(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);

}
