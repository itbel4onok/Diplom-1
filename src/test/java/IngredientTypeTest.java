import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;

public class IngredientTypeTest {
    @Test
    public void ingredientTypeContainSauceValue() {
        Assert.assertNotNull(IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void ingredientTypeContainFillingValue() {
        Assert.assertNotNull(IngredientType.valueOf("FILLING"));
    }
}
