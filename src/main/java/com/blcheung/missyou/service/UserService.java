package com.blcheung.missyou.service;

import com.blcheung.missyou.exception.http.ForbiddenException;
import com.blcheung.missyou.kit.LocalUserKit;
import com.blcheung.missyou.model.User;
import com.blcheung.missyou.model.UserAddress;
import com.blcheung.missyou.repository.UserAddressRepository;
import com.blcheung.missyou.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository        userRepository;
    @Autowired
    private UserAddressRepository userAddressRepository;

    public User getUserById(Long uid) { return this.userRepository.findFirstById(uid); }

    public List<UserAddress> getUserAddressList() {
        Long userId = LocalUserKit.getUser()
                                  .getId();

        List<UserAddress> userAddressList = this.userAddressRepository.findAllByUserIdOrderByUpdateTimeDesc(userId);
        if (userAddressList.isEmpty()) return Collections.emptyList();

        return userAddressList;
    }

    public UserAddress getUserAddressById(Long userId, Long addressId) {
        return this.userAddressRepository.findByIdAndUserId(addressId, userId)
                                         .orElseThrow(() -> new ForbiddenException(70007));
    }
}
