package org.sid.ebankingbackend.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.ebankingbackend.dtos.CustomerDto;
import org.sid.ebankingbackend.entities.Customer;
import org.sid.ebankingbackend.exceptions.CustomerNotFoundException;
import org.sid.ebankingbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@Slf4j

public class CustomerRestController {
    private BankAccountService bankAccountService;
    @GetMapping("/customers")
    public List<CustomerDto> customers(){
        return bankAccountService.listCustomers();
    }


    @GetMapping("/customers/search")
    public List<CustomerDto> SearchCustomers(@RequestParam(
            value = "keyword",defaultValue = "")String keyword){

        return bankAccountService.searchCustomer("%"+keyword+"%");
    }

    @GetMapping("/customers/{id}")
    public CustomerDto getCustomer(@PathVariable(name = "id") Long customerId) throws CustomerNotFoundException {
        return bankAccountService.getCustomer(customerId);
    }
    @PostMapping("/customers")
    public  CustomerDto saveCustomer(@RequestBody  CustomerDto customerDto){
        return bankAccountService.saveCustomer(customerDto);
    }
    @PutMapping("/customers/{customerID}")
    public  CustomerDto updateCustomer( @PathVariable Long customerID ,@RequestBody CustomerDto customerDto){
        customerDto.setId(customerID); //Request body pour l'update
        return bankAccountService.updateCustomer(customerDto);
    }
    @DeleteMapping("/customers/{id}")
    public void deleteCustomer( @PathVariable Long id){
        bankAccountService.deleteCustomer(id);
    }
}
