package accenture.challenge.recruiting.bff.fixtures;

import accenture.challenge.recruiting.bff.dtos.CategoryDto;

import java.util.List;

import static accenture.challenge.recruiting.bff.fixtures.Fixture.readFileFromResources;

public class ServicesFixture {

    private static List<CategoryDto> categories;

    static {
        categories = (List<CategoryDto>) readFileFromResources("services/getCategories.json",
                CategoryDto.class, true);
    }

    public static List<CategoryDto> getCategories() {
        return categories;
    }

}