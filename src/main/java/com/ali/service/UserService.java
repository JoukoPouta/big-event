package com.ali.service;

import com.ali.pojo.User;

public interface UserService {
    //根据用户名查询
    User findByUserName(String username);

    void register(String username, String password);
    //更新
    void update(User user);
    //更新头像
    void updateAvatar(String avatarUrl);
    //更新密码
    void updatePwd(String newPwd);
}
