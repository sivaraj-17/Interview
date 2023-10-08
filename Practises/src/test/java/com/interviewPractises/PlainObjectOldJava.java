package com.interviewPractises;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PlainObjectOldJava {
    public static void main(String[] args) {
        POJO pojo = new POJO();
        pojo.setProductBasedCompany1("Amazon");
        pojo.setProductBasedCompany2("Google");
        pojo.setProductBasedCompany3("Microsoft");

        System.out.println(pojo.getProductBasedCompany1());
        System.out.println(pojo.getProductBasedCompany2());
        System.out.println(pojo.getProductBasedCompany3());

        convertToJson(pojo);
    }
    static void convertToJson(POJO pojo){
        ObjectMapper obj = new ObjectMapper();
        try {
            String s = obj.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
