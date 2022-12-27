package com.lab01.individualgradedassignments01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class CredentialService {
    private static final String ALPHABETS_STRING_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHABETS_STRING_NOCAPS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SPECIAL_STRING = "#$^&*.+-";
    private static final int RANDOM_SIZE = 3;

    public static String generatePassword() {
        ArrayList<String> randomizedList = new ArrayList<>();
        StringBuilder randomPassword = new StringBuilder();
        randomizedList.add(RandomStringUtils.random(RANDOM_SIZE, ALPHABETS_STRING_CAPS));
        randomizedList.add(RandomStringUtils.random(RANDOM_SIZE, ALPHABETS_STRING_NOCAPS));
        randomizedList.add(RandomStringUtils.random(RANDOM_SIZE, NUMBERS));
        randomizedList.add(RandomStringUtils.random(RANDOM_SIZE, SPECIAL_STRING));
        Collections.shuffle(randomizedList);
        for (int i = 0; i < randomizedList.size(); i++) {
            randomPassword.append(randomizedList.get(i));
        }
        ArrayList<Character> randomizingCharacters = (ArrayList<Character>) randomPassword.chars()
                .mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.shuffle(randomizingCharacters);
        return StringUtils.join(randomizingCharacters, "");
    }

    public static String generateEmailAddress(Employee employee) {
        return new StringBuilder().append(employee.getFirstName().toLowerCase())
                .append(employee.getLastName().toLowerCase()).append("@")
                .append(employee.getDepartment().getDepartmentName()).append(".company.com").toString();
    }

    public static String showCredentials(Employee employee) {
        StringBuilder credentialsForDisplay = new StringBuilder();
        credentialsForDisplay.append("Dear ").append(employee.getFirstName())
                .append(" your generated credentials are as follows:");
        credentialsForDisplay.append("\n");
        credentialsForDisplay.append("Email ---> ").append(employee.getEmailAddress());
        credentialsForDisplay.append("\n");
        credentialsForDisplay.append("Password ---> ").append(employee.getPassword());
        credentialsForDisplay.append("\n");
        return credentialsForDisplay.toString();
    }

    private CredentialService() {
    }
}
