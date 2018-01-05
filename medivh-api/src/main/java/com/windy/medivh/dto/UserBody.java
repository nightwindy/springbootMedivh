package com.windy.medivh.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserBody implements Serializable{
    private String name;
    private String Id;

}
