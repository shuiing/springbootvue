package com.shui.sqlite.mapper;

import com.shui.sqlite.data.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    User findUser(String id);
}
