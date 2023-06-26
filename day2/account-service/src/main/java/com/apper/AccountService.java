package com.apper;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {

    private List<Account> accounts = new ArrayList<>();
    private IDGeneratorService idGeneratorService = new IDGeneratorService();

    public Account create(String firstName, String lastName, String username, String clearPassword) {
        Account account = new Account();
        account.setId(idGeneratorService.getNextID());
        account.setBalance(1_000.0);

        LocalDateTime now = LocalDateTime.now();
        account.setCreationDate(now);
        account.setLastUpdated(now);

        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setUsername(username);
        account.setClearPassword(clearPassword);
        account.setVerificationCode(idGeneratorService.generateRandomCharacters(6));

        accounts.add(account);

        return account;
    }

    public Account get(String accountId) {
        for (Account account : accounts) {
            if (account.getId().equals(accountId)) {
                return account;
            }
        }

        return null;
    }

    public List<Account> getAll(){
        return accounts;
    }

       public Account update(String AccountId, String firstName, String lastName, String username, String clearPassword) {
        Account account= get(AccountId);
        LocalDateTime now = LocalDateTime.now();
        account.setCreationDate(now);
        account.setLastUpdated(now);

        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setUsername(username);
        account.setClearPassword(clearPassword);
        account.setVerificationCode(idGeneratorService.generateRandomCharacters(6));


           return account;
       }
//

public void deleteAccount(String AccountId) {
            accounts.remove(get(AccountId));

}



}