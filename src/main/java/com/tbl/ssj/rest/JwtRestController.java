package com.tbl.ssj.rest;

import com.tbl.ssj.Untils.payload.LoginRequest;
import com.tbl.ssj.Untils.payload.LoginResponse;
import com.tbl.ssj.Untils.payload.RandomStuff;
import com.tbl.ssj.Untils.security.JwtTokenProvider;
import com.tbl.ssj.bo.AccountBO;
import com.tbl.ssj.bo.security.CustomUserDetails;
import com.tbl.ssj.service.AccountService;
import com.tbl.ssj.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class JwtRestController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AccountService accountService;

    @PostMapping("/login")
    public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        System.out.println(passwordEncoder.encode("123"));

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );


        SecurityContextHolder.getContext().setAuthentication(authentication);


        String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
        System.out.println(UserService.getCurrentUserLogin());
        return new LoginResponse(jwt);
    };


    @GetMapping("/random")
    public RandomStuff randomStuff(){
        return new RandomStuff("JWT Hợp lệ mới có thể thấy được message này");
    };

    @PostMapping("/save")
    public void save(@RequestBody AccountBO accountBO){
        AccountBO accountBO1 = new AccountBO(accountBO.getUserName(),passwordEncoder.encode(accountBO.getPassword()));
        accountService.save(accountBO1);
    }
}
