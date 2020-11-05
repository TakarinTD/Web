package com.example.easynotes.service;

public interface SecurityService {
    String findLoggedInUserName ();

    void autoLogin (String userName, String password);
}
