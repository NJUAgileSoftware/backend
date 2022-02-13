package com.bolingcavalry.mavendockerplugindemo.Service.Account;

import com.bolingcavalry.mavendockerplugindemo.VO.UserForm;
import com.bolingcavalry.mavendockerplugindemo.VO.UserVO;

public interface AccountService {

    UserVO login(UserForm userForm);

    UserVO getUserInfo(long id);
}
