package org.sid.ebankingbackend.dtos;

import lombok.Data;

import java.util.List;
@Data
public class AccountHistoryDTO {
    List<AccountOperationDTO> accountOperationDTOS;
    private double balance;
    private String accountId;
    private int currentPage;
    private int totalPages;
    private int pageSize;

}
