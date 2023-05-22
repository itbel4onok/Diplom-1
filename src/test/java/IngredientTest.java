import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;
import org.junit.Assert;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {
    public IngredientType type;
    public String name;
    public float price;
    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Class Ingredient, type: {0}, name: {1}, price: {2}")
    public static Object[][] IngredientTestData() {
        return new Object[][] {
                { IngredientType.SAUCE, "hot sauce", 100 },
                { IngredientType.FILLING, "dinosaur", 200 },
        };
    }

    @Test
    public void getPriceReturnIngredientPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void getNameReturnIngredientName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }

    @Test
    public void getTypeReturnIngredientType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        Assert.assertEquals(type, ingredient.getType());
    }
}
