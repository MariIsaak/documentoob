package com.example.documentoob.service;

import com.example.documentoob.model.UserDtls;

public interface UserService {

    public UserDtls createUser(UserDtls user);

    public boolean checkEmail(String email);


}