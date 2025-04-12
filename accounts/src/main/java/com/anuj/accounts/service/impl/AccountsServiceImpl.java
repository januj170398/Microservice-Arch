package com.anuj.accounts.service.impl;

import com.anuj.accounts.Exception.CustomerAlreadyExistException;
import com.anuj.accounts.Exception.ResourceNotFoundException;
import com.anuj.accounts.constants.AccountsConstants;
import com.anuj.accounts.dto.AccountsDto;
import com.anuj.accounts.dto.CustomerDto;
import com.anuj.accounts.entity.Accounts;
import com.anuj.accounts.entity.Customer;
import com.anuj.accounts.enums.AccountType;
import com.anuj.accounts.mapper.CustomerMapper;
import com.anuj.accounts.repository.AccountsRepository;
import com.anuj.accounts.repository.CustomerRepository;
import com.anuj.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistException("Customer Already Exists with the given number: " + customerDto.getMobileNumber());
        }
        
        // Set base entity fields
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous"); // You might want to get this from security context
        
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }


    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountType.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);
        
        // Set base entity fields
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("Anonymous"); // You might want to get this from security context
        
        return newAccount;
    }

    @Override
    public CustomerDto fetchAccountDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(()-> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(()-> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));
        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
        customerDto.setAccountsDto(new AccountsDto(accounts.getAccountNumber(), accounts.getAccountType(), accounts.getBranchAddress()));
        return customerDto;
    }

}
