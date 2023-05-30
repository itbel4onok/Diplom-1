import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;

    private final Burger burger = new Burger();

    @Test
    public void addIngredientAddedIngredientToTheList() {
        int firstIndexOfList = 1;
        burger.addIngredient(ingredient);
        assertEquals(firstIndexOfList, burger.ingredients.size());
    }

    @Test
    public void removeIngredientRemoveIngredientFromList() {
        int zeroIndexOfList = 0;
        burger.addIngredient(ingredient);
        burger.removeIngredient(zeroIndexOfList);
        assertEquals(zeroIndexOfList, burger.ingredients.size());
    }

    @Test
    public void moveIngredientMovedIngredientInList() {
        int zeroIndexOfList = 0;
        int firstIndexOfList = 1;
        Ingredient spyIngredient = Mockito.spy(new Ingredient(IngredientType.FILLING,
                "sausage", 300));
        burger.addIngredient(spyIngredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(zeroIndexOfList,firstIndexOfList);
        assertEquals(burger.ingredients.get(firstIndexOfList), spyIngredient);
    }

    @Test
    public void getPriceReturnFloatPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        assertEquals(500F, burger.getPrice(), 0.0f);
    }
}

