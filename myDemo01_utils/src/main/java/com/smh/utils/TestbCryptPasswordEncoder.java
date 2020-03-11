package com.smh.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author ：smh
 * @description：TODO
 * @date ：2020/2/22 11:26
 */
public class TestbCryptPasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.out.println(bCryptPasswordEncoder.encode("5630267"));
    }
}
