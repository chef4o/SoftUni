package com.bankingService;

import com.bankingService.error.*;
import com.bankingService.frontEnd.OnScreenMessaging;
import com.bankingService.service.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.naming.InsufficientResourcesException;
import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final UserService userService;
    private final AccountService accountService;
    private final BufferedReader reader;

    public ConsoleRunner(UserService userService, AccountService accountService, BufferedReader reader) {
        this.userService = userService;
        this.accountService = accountService;
        this.reader = reader;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(OnScreenMessaging.PROGRAM_START);
        Map<String, List<String>> structure = generateHumanReadableStructure(
                                            "service",
                                                getClassesNames("service"));
        String selectedService = null;
        String selectedMethod = null;

        boolean successfulOperation = false;
        while (!successfulOperation) {
            try {
                System.out.println(OnScreenMessaging.OPTIONS);
                System.out.println(structure.keySet());
                selectedService = stringNormalizer(this.reader.readLine());
                serviceValidation(structure, selectedService);
                while (!successfulOperation) {
                    try {
                        System.out.println(OnScreenMessaging.OPTIONS);
                        System.out.println(structure.get(selectedService));
                        selectedMethod = stringNormalizer(this.reader.readLine());
                        methodValidation(structure, selectedService, selectedMethod);
                        while (!successfulOperation) {
                            try {
                                executeCommand(selectedService, selectedMethod);
                            } catch (UserAlreadyExistsException | InsufficientFundsException exception) {
                                System.out.println(exception.getClass().getSimpleName());
                            }
                            successfulOperation = consentToProceed(selectedMethod);
                        }
                    } catch (NoSuchServiceException e) {
                        System.out.println(e);
                    }
                    successfulOperation = consentToProceed(structure.get(selectedService)
                                                                    .toString());
                }
            } catch (NoSuchServiceException e) {
                System.out.println(e);
            }
            successfulOperation = consentToProceed(structure.keySet()
                                                            .toString());
        }

        System.out.println(OnScreenMessaging.PROGRAM_END);
    }

    public boolean consentToProceed(String selection) throws IOException {
        return "no".equals(getConsent(selection));
    }

    private String getConsent(String selection) throws IOException {
        System.out.println(OnScreenMessaging.PROCEED);
        System.out.println(selection);
        System.out.println(OnScreenMessaging.CONSENT_OPTIONS);
        return this.reader.readLine().toLowerCase();
    }

    private void methodValidation(Map<String, List<String>> servicesNames, String selectedClass, String selectedMethod) {
        validateEquality(new ArrayList<>(servicesNames.get(selectedClass)), selectedMethod);
    }

    private void serviceValidation(Map<String, List<String>> servicesNames, String selectedOption) {
        validateEquality(new ArrayList<>(servicesNames.keySet()),
                        stringNormalizer(selectedOption));
    }

    public static String stringNormalizer(String text) {
           return WordUtils.capitalizeFully(text.replaceAll("\\s+", " "));
    }

    public static String methodNameNormalizer(String methodName) {
        String regex = "([A-Z][a-z]+)";
        String replacement = "$1 ";
        return WordUtils.capitalize(methodName)
                                 .replaceAll(regex, replacement)
                                 .trim();
    }

    private void validateEquality(List<String> convertedNames, String inputString) {
        if (!convertedNames.contains(inputString)) {
            throw new NoSuchServiceException();
        }
    }

    private static List<String> getClassesNames(String ofType) {

        Reflections reflections = new Reflections("com.bankingService." + ofType,
                                                    new SubTypesScanner(false));

        return new ArrayList<>(
                reflections.getSubTypesOf(Object.class))
                .stream()
                .map(Class::getSimpleName)
                .filter(c -> c.endsWith(WordUtils.capitalize(ofType)))
                .collect(Collectors.toList());
    }

    private static List<String> getClassMethods(String ofType, String className) throws ClassNotFoundException {
        final String fullClassName = "com.bankingService." + ofType + "." + className;
        Class<?> currentClass = Class.forName(fullClassName);

        return Arrays.stream(currentClass.getMethods())
                .map(m -> methodNameNormalizer(m.getName()))
                .toList();
    }

    private static Map<String, List<String>> generateHumanReadableStructure(String ofType, List<String> classesNames)
            throws ClassNotFoundException {
        Map<String, List<String>> output = new LinkedHashMap<>();
        for (String name : classesNames) {
            String normalizedServiceName = String.join(" ",
                    StringUtils
                            .splitByCharacterTypeCamelCase(name.concat("s")));
            output.put(normalizedServiceName, getClassMethods(ofType, name));
        }
        return output;
    }

    private void executeCommand(String service, String method) {

        try {
            switch (service) {
                case "User Services" -> {
                    switch (method) {
                        case "Register User" -> {
                            System.out.println(OnScreenMessaging.USERNAME);
                            String username = this.reader.readLine();

                            System.out.println(OnScreenMessaging.AGE);
                            Short age = Short.valueOf(this.reader.readLine());

                            System.out.println(OnScreenMessaging.AMOUNT);
                            BigDecimal amount = new BigDecimal(this.reader.readLine());

                            this.userService.registerUser(username, age, amount);
                            System.out.println(OnScreenMessaging.COMPLETED);
                        }
                        case "Add Bank Account" -> {
                            System.out.println(OnScreenMessaging.USER_ID);
                            long id = Long.parseLong(reader.readLine());

                            System.out.println(OnScreenMessaging.AMOUNT);
                            BigDecimal amount = new BigDecimal(this.reader.readLine());

                            this.userService.addBankAccount(id, amount);
                        }
                    }
                }
                case "Account Services" -> {
                    System.out.println(OnScreenMessaging.AMOUNT);
                    BigDecimal amount = new BigDecimal(this.reader.readLine());
                    switch (method) {
                        case "Upload Money" -> {
                            System.out.println(OnScreenMessaging.SENDER_ID);
                            long senderId = Long.parseLong(this.reader.readLine());

                            this.accountService.uploadMoney(amount,senderId);
                        }
                        case "Withdraw Money" -> {
                            System.out.println(OnScreenMessaging.SENDER_ID);
                            long senderId = Long.parseLong(this.reader.readLine());

                            this.accountService.withdrawMoney(amount,senderId);
                        }
                        case "Transfer Between Accounts" -> {
                            System.out.println(OnScreenMessaging.SENDER_ACC_ID);
                            long senderId = Long.parseLong(this.reader.readLine());

                            System.out.println(OnScreenMessaging.RECEIVER_ACC_ID);
                            long receiverId = Long.parseLong(this.reader.readLine());
                            this.accountService.transferBetweenAccounts(senderId, receiverId, amount);
                        }
                    }
                }
            }
        } catch (IOException | RuntimeException |InsufficientResourcesException e) {
            System.out.println(e);
        }
    }
}
