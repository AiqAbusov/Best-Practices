package com.example.demo.service;

import com.example.demo.exception.DiamondEnum;
import com.example.demo.exception.SystemException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ServiceOne {

    public void testException() {
        throw new SystemException(DiamondEnum.DIAMOND_TIMEOUT)
                .set("url", "url")
                .set("username", "Aiq");
    }

    public static void main(String[] args) {
        ServiceOne serviceOne = new ServiceOne();
        try {
            serviceOne.testException();
        } catch (SystemException systemException) {
            if (Objects.equals(systemException.getErrors().getErrorCode(), DiamondEnum.DIAMOND_TIMEOUT.getErrorCode()))
                System.err.println("It is Diamond Request Timeout Exception" + systemException.getProperties());
            System.err.println(systemException.getErrorText(DiamondEnum.DIAMOND_TIMEOUT));
        }

    }

}
