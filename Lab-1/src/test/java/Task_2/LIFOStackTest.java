package Task_2;

import java.util.Iterator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testclass for LIFOStack
 * @author Alexander
 */
public class LIFOStackTest {    
    LIFOStack testStack;
    
    @BeforeEach
    public void setUp() {
        
    }
    
    @AfterEach
    public void tearDown() {
        
    }

    /**
     * Test of push method, of class LIFOStack.
     */
    @Test
    public void testPush() {
        System.out.println("push");
        Object item = null;
        LIFOStack instance = new LIFOStack();
        instance.push(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pop method, of class LIFOStack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        LIFOStack instance = new LIFOStack();
        Object expResult = null;
        Object result = instance.pop();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class LIFOStack.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        LIFOStack instance = new LIFOStack();
        boolean expResult = false;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class LIFOStack.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        LIFOStack instance = new LIFOStack();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
