package com.decagon.entity.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactInformation {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

//TODO receives user's fullname user service, split into firstName and LastName
}