package com.tbl.ssj.bo;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class AccountBO {
    @Id
    @Column(name = "ACCOUNT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Column(name = "USERNAME", columnDefinition = "nvarchar (70)")
    private String userName;
    @Column(name = "PASSWORD", columnDefinition = "nvarchar (70)")
    private String password;

    public AccountBO() {
    }

    public AccountBO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
