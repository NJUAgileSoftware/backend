package com.bolingcavalry.mavendockerplugindemo.ServiceImpl.Account;

import com.bolingcavalry.mavendockerplugindemo.Dao.AccountMapper;
import com.bolingcavalry.mavendockerplugindemo.PO.User;
import com.bolingcavalry.mavendockerplugindemo.Service.Account.AccountService;
import com.bolingcavalry.mavendockerplugindemo.VO.UserForm;
import com.bolingcavalry.mavendockerplugindemo.VO.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.Ssl;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public UserVO login(UserForm userForm){

        User user = accountMapper.getUserByName(userForm.getUsername());


        if(user==null || !user.getPassword().equals(userForm.getPassword())){
            return null;
        }
        return new UserVO(user);
    }

    @Override
    public UserVO getUserInfo(long id){
        User user=accountMapper.getUserById(id);
        if(user==null){
            return null;
        }
        return new UserVO(user);
    }


}
