package com.tbl.ssj.service.security;

import com.tbl.ssj.bo.AccountBO;
import com.tbl.ssj.bo.security.CustomUserDetails;
import com.tbl.ssj.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private AccountDAO accountDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  
        AccountBO accountBO = accountDAO.findByUsername(username);
        if (accountBO == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(accountBO);
    }


    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {

        AccountBO accountBO = accountDAO.findById(id);
        if (accountBO == null) {
            throw new NullPointerException();
        }
        return new CustomUserDetails(accountBO);
    }

    public static Optional<String> getCurrentUserLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(securityContext.getAuthentication())
                .map(authentication -> {
                    if (authentication.getPrincipal() instanceof UserDetails) {
                        UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
                        return springSecurityUser.getUsername();
                    } else if (authentication.getPrincipal() instanceof String) {
                        return (String) authentication.getPrincipal();
                    }
                    return null;
                });
    }

}
