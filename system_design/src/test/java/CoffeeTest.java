import com.systemdesign.lowlevel.decorator.example2.Coffee;
import com.systemdesign.lowlevel.decorator.example2.MilkDecorator;
import com.systemdesign.lowlevel.decorator.example2.SimpleCoffee;
import com.systemdesign.lowlevel.decorator.example2.SugarDecorator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CoffeeTest {

    @Test
    public void testSimpleCoffee() {
        Coffee simpleCoffee = new SimpleCoffee();
        assertEquals("Simple Coffee", simpleCoffee.getDescription());
        assertEquals(5.0, simpleCoffee.getCost());
    }

    @Test
    public void testMilkDecorator() {
        Coffee simpleCoffee = new SimpleCoffee();
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        assertEquals("Simple Coffee, Milk", milkCoffee.getDescription());
        assertEquals(6.5, milkCoffee.getCost());
    }

    @Test
    public void testSugarDecorator() {
        Coffee simpleCoffee = new SimpleCoffee();
        Coffee sugarCoffee = new SugarDecorator(simpleCoffee);
        assertEquals("Simple Coffee, Sugar", sugarCoffee.getDescription());
        assertEquals(5.5, sugarCoffee.getCost());
    }

    @Test
    public void testMilkAndSugarDecorators() {
        Coffee simpleCoffee = new SimpleCoffee();
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        Coffee milkAndSugarCoffee = new SugarDecorator(milkCoffee);
        assertEquals("Simple Coffee, Milk, Sugar", milkAndSugarCoffee.getDescription());
        assertEquals(7.0, milkAndSugarCoffee.getCost());
    }

    @Test
    public void testMultipleDecoratorsOrderIndependence() {
        Coffee simpleCoffee = new SimpleCoffee();
        Coffee sugarCoffee = new SugarDecorator(simpleCoffee);
        Coffee sugarAndMilkCoffee = new MilkDecorator(sugarCoffee);
        assertEquals("Simple Coffee, Sugar, Milk", sugarAndMilkCoffee.getDescription());
        assertEquals(7.0, sugarAndMilkCoffee.getCost());
    }
}
