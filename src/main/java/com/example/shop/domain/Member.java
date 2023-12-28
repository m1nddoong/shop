package com.example.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // 기본 생성자?
public class Member {
    private String name;
    private String id;
    private String password;
    private String email;
    private String phone;
}
