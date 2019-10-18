package com.tbl.ssj.service;

import com.tbl.ssj.bo.AccountBO;

public interface AccountService {
    public AccountBO findByUsername(String username);

    public AccountBO findById(Long id);

    public void save(AccountBO accountBO);
}
