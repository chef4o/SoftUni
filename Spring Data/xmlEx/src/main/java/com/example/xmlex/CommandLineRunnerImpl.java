package com.example.xmlex;

import com.example.xmlex.model.dto.CategorySeedRootDto;
import com.example.xmlex.model.dto.UserSeedRootDto;
import com.example.xmlex.service.CategoryService;
import com.example.xmlex.service.UserService;
import com.example.xmlex.util.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

import static com.example.xmlex.constants.GlobalConstants.*;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final XmlParser xmlParser;
    private final CategoryService categoryService;
    private final UserService userService;

    public CommandLineRunnerImpl(XmlParser xmlParser, CategoryService categoryService, UserService userService) {
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() throws JAXBException, FileNotFoundException {
        if (this.categoryService.getEntityCount() == 0) {
            CategorySeedRootDto categorySeedRootDto = this.xmlParser.fromFile(
                    RESOURCES_FILE_PATH + RESOURCES_FILE_NAME_CATEGORIES,
                    CategorySeedRootDto.class);
            this.categoryService.seedCategories(categorySeedRootDto.getCategories());
        }

        if (this.userService.getUserCount() == 0) {
            UserSeedRootDto userSeedRootDto = this.xmlParser.fromFile(
                    RESOURCES_FILE_PATH + RESOURCES_FILE_NAME_USERS,
                    UserSeedRootDto.class);
            this.userService.seedUsers(userSeedRootDto.getUsers());
        }


    }
}
