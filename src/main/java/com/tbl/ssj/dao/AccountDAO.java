package com.tbl.ssj.dao;

import com.tbl.ssj.Untils.BaseHibernateDAO;
import com.tbl.ssj.bo.AccountBO;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class AccountDAO extends BaseHibernateDAO {

    /**
     * @TODO:Tim kiem tai khoan theo username
     * @param username
     * @return AccountBO
     */
    public AccountBO findByUsername(String username){
        AccountBO accountBO = new AccountBO();
        String hql = " FROM AccountBO a WHERE a.userName = :username ";
        Query query = getSession().createQuery(hql);
        query.setParameter("username",username);
        List<AccountBO> listAcc = query.list();
        if(listAcc!=null && listAcc.size() ==1 ){
            accountBO =  listAcc.get(0);
        }
        return accountBO;
    }

    /**
     * @TODO:Tim kiem tai khoan theo id
     * @param id
     * @return AccountBO
     */
    public AccountBO findById(Long id){
        AccountBO accountBO = new AccountBO();
        String hql = " FROM AccountBO a WHERE a.accountId = :id ";
        Query query = getSession().createQuery(hql);
        query.setParameter("id",id);
        List<AccountBO> listAcc = query.list();
        if(listAcc!=null && listAcc.size() ==1 ){
            accountBO =  listAcc.get(0);
        }
        return accountBO;
    }

    /**
     * todo : them 1 ban ghi
     * @param accountBO
     */
    public void save(AccountBO accountBO){
        getSession().save(accountBO);
    }

}
