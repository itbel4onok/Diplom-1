import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerParamsTest {

    private final Burger burger = new Burger();
    public String bunName;
    public float bunPrice;
    public IngredientType ingredientType;
    public String ingredientName;
    public float ingredientPrice;
    public BurgerParamsTest(String bunName, float bunPrice, IngredientType ingredientType,
                            String ingredientName, float ingredientPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters(name = "Class Burger, bun name: {0}, ingredient name: {3}")
    public static Object[][] SetBurgerData() {
        return new Object[][] {
                { "red bun", 300F, IngredientType.SAUCE, "hot sauce", 100F },
                { "white bun", 200F, IngredientType.FILLING, "dinosaur", 200F },
        };
    }

    @Test
    public void getReceiptOneIngredientReturnReceipt() {
        mockData();
        assertEquals(generateExpectedString(), burger.getReceipt());
    }

    @Test
    public void getReceiptThreeIngredientsReturnReceipt() {
        mockDataThreeIngredients();
        assertEquals(generateExpectedString(), burger.getReceipt());
    }

    private void mockData(){
        Bun bun = Mockito.mock(Bun.class);
        Ingredient ingredient = Mockito.mock(Ingredient.class);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
    }

    private void mockDataThreeIngredients(){
        mockData();
        burger.addIngredient(Mockito.spy(new Ingredient(IngredientType.SAUCE, "sour cream", 200)));
        burger.addIngredient(Mockito.spy(new Ingredient(IngredientType.FILLING, "sausage", 300)));
    }

    private String generateExpectedString(){
        StringBuilder expectedReceipt = new StringBuilder(String.format("(==== %s ====)%n", bunName));
        for (Ingredient ingredient : burger.ingredients) {
            expectedReceipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }
        expectedReceipt.append(String.format("(==== %s ====)%n", bunName));
        expectedReceipt.append(String.format("%nPrice: %f%n", burger.getPrice()));
        return expectedReceipt.toString();
    }
}

