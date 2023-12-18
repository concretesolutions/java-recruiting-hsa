package fixtures;

import accenture.challenge.recruiting.ms.domains.CategoryThree;

import static accenture.challenge.recruiting.ms.fixtures.Fixture.readFileFromResources;

public class CategoryApiFixture {

    private static CategoryThree categories;

    static {
        categories = readFileFromResources("categoryApi/getCategories.json", CategoryThree.class);
    }

    public static CategoryThree getcategories() {
        return categories;
    }

}