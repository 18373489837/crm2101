package com.zhaoliwei.service;

public interface LoginService {
    public int loginSe(String username,String password);

    public boolean modification(String username ,String password);

    public boolean register(String username,String password);
}
