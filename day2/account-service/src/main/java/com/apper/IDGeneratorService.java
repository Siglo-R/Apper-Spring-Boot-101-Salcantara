package com.apper;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;
public class IDGeneratorService {
    public String generateRandomCharacters(int length){
        String generatedString = RandomStringUtils.randomAlphanumeric(length);
        return generatedString;
    }
    public String getNextID() {
        String id = UUID.randomUUID().toString();
        return id;
    }


}
