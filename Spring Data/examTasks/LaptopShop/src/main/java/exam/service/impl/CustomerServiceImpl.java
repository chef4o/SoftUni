package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.CustomerSeedDto;
import exam.model.entity.Customer;
import exam.model.entity.Town;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final String CUSTOMER_DATA_JSON = "src/main/resources/files/json/customers.json";
    private final CustomerRepository customerRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final TownRepository townRepository;
    private final Gson gson;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               ValidationUtil validationUtil, ModelMapper modelMapper,
                               TownRepository townRepository, Gson gson) {
        this.customerRepository = customerRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(CUSTOMER_DATA_JSON));
    }

    @Override
    public String importCustomers() throws IOException {
        if (!areImported()) {
            StringBuilder output = new StringBuilder();
            Arrays.stream(gson
                            .fromJson(readCustomersFileContent(), CustomerSeedDto[].class))
                    .filter(customerSeedDto -> {
                        boolean isValid = validationUtil.isValid(customerSeedDto);
                        output.append(generateSeedResponse(customerSeedDto.getFirstName(),
                                customerSeedDto.getLastName(), customerSeedDto.getEmail(),
                                isValid));
                        return isValid;
                    })
                    .map(customerSeedDto -> {
                        Customer customer = modelMapper.map(customerSeedDto, Customer.class);
                        Town town = townRepository.getTownByName(customerSeedDto.getTown().getName());
                        customer.setTown(town);
                        return customer;
                    })
                    .forEach(customerRepository::save);

            return output.toString().trim();
        }
        return null;
    }

    private String generateSeedResponse(String firstName, String lastName, String email, boolean isValid) {
        return isValid
                ? String.format("Successfully imported Customer %s %s - %s%s",
                firstName, lastName, email, System.lineSeparator())
                : String.format("Invalid Customer%s", System.lineSeparator());
    }
}
