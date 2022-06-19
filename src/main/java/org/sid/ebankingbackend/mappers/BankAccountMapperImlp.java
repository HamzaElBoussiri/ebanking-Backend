package org.sid.ebankingbackend.mappers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.sid.ebankingbackend.dtos.AccountOperationDTO;
import org.sid.ebankingbackend.dtos.CurrentBankAccountDTO;
import org.sid.ebankingbackend.dtos.CustomerDto;
import org.sid.ebankingbackend.dtos.SavingBankAccountDTO;
import org.sid.ebankingbackend.entities.AccountOperation;
import org.sid.ebankingbackend.entities.CurrentAccount;
import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.entities.SavingAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapperImlp {
   public CustomerDto fromCustomer(Customer customer){
        CustomerDto customerDto=new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
       // customerDto.setId(customer.getId());
        //customerDto.setEmail(customer.getEmail());
        //customerDto.setName(customer.getName());
        return customerDto ;
    }
    public Customer fromCustomerDto(CustomerDto customerDto){
        Customer customer=new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        return customer;
    }
    public SavingBankAccountDTO fromSavingBankAccount(SavingAccount savingAccount){
       SavingBankAccountDTO savingBankAccountDTO=new SavingBankAccountDTO();
       BeanUtils.copyProperties(savingAccount,savingBankAccountDTO);
       savingBankAccountDTO.setCustomerDto(fromCustomer(savingAccount.getCustomer()));
        savingBankAccountDTO.setType(savingAccount.getClass().getSimpleName());
       return savingBankAccountDTO;
    }
    public SavingAccount fromSavingBankAccountDTO(SavingBankAccountDTO  savingBankAccountDTO){
       SavingAccount savingAccount=new SavingAccount();
       BeanUtils.copyProperties(savingBankAccountDTO,savingAccount);
       savingAccount.setCustomer(fromCustomerDto(savingBankAccountDTO.getCustomerDto()));
       return savingAccount;
    }
    public CurrentBankAccountDTO fromCurrentAccount(CurrentAccount  currentAccount){
       CurrentBankAccountDTO currentBankAccountDTO=new CurrentBankAccountDTO();
       BeanUtils.copyProperties(currentAccount,currentBankAccountDTO);
       currentBankAccountDTO.setCustomerDto(fromCustomer(currentAccount.getCustomer()));
        currentBankAccountDTO.setType(currentAccount.getClass().getSimpleName());
       return  currentBankAccountDTO;
    }
    public  CurrentAccount fromCurrentBankAccountDTO(CurrentBankAccountDTO currentBankAccountDTO){
       CurrentAccount currentAccount=new CurrentAccount();
       BeanUtils.copyProperties(currentBankAccountDTO,currentAccount);
        currentAccount.setCustomer(fromCustomerDto(currentBankAccountDTO.getCustomerDto()));
       return  currentAccount;
    }
    public AccountOperationDTO fromAccountOperation(AccountOperation accountOperation){
       AccountOperationDTO accountOperationDTO=new AccountOperationDTO();
       BeanUtils.copyProperties(accountOperation,accountOperationDTO);
       return accountOperationDTO;
    }
    public  AccountOperation fromAccountOperationDTO(AccountOperationDTO accountOperationDTO){
       AccountOperation accountOperation=new AccountOperation();
       BeanUtils.copyProperties(accountOperationDTO,accountOperation);
       return accountOperation;
    }


}
