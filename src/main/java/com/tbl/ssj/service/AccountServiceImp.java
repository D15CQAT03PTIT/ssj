package com.tbl.ssj.service;

import com.tbl.ssj.bo.AccountBO;
import com.tbl.ssj.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountDAO accountDAO;


    @Override
    public AccountBO findByUsername(String username) {
        return accountDAO.findByUsername(username);
    }

    @Override
    public AccountBO findById(Long id) {
        return accountDAO.findById(id);
    }

    @Override
    public void save(AccountBO accountBO) {
        accountDAO.save(accountBO);
    }
}
