package com.act.springsecurity_1.impl;

import com.act.springsecurity_1.CustomUserDetails;
import com.act.springsecurity_1.User;

public class CustomUserDetailImpl extends CustomUserDetails {
    public CustomUserDetailImpl(User user) {
        super(user);
    }
}
