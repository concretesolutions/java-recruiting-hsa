package accenture.challenge.recruiting.bff.fixtures;

import accenture.challenge.recruiting.bff.domains.CategoryThree;

public class CategoryClientFixture {

    private static CategoryThree categoryThree;

    static {
        categoryThree = Fixture.readFileFromResources("categoryClient/getCategoryThree.json",
                CategoryThree.class, false);
    }

    public static CategoryThree getCategoryThree() {
        return categoryThree;
    }

}