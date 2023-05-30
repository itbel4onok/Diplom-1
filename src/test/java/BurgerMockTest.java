import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {
    @Mock
    Bun buns;
    @Mock
    Burger burger;

    @Test
    public void setBunsSetBun() {
        burger.setBuns(buns);
        Mockito.verify(burger).setBuns(buns);
    }
}

