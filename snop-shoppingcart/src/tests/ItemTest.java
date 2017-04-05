/**
 * TCSS 305 – Autumn 2015 Assignment 2 – Item Class Testing
 */

package tests;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import model.Item;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Sophie Nop
 * @version 17 October 2015
 */
public class ItemTest {

    /**
     * The item I will use in the test.
     */
    private Item myItem;
    
    /**
     * Items sold in groups at a discount. 
     */
    private Item myBulkItem;
    
    /**
     * An item identical to the one above for testing the equals method.
     */
    private Item myIdenticalBulkItem;
    
    /**
     * Setting up myItem with String and BigDecimal values.
     */
    @Before
    public void setUp() {
        myItem = new Item("Peter's Xbox", new BigDecimal("349.99"));
        myBulkItem = new Item("Soda", new BigDecimal("1.00"), 6, new BigDecimal("3.50"));
        myIdenticalBulkItem = 
                        new Item("Soda", new BigDecimal("1.00"), 6, new BigDecimal("3.50"));
    }

    /**
     * Test that calculations for non-bulk items work correctly.
     * 10 items at 349.99 ea = 3499.90
     * Also checks that isBulk is consistent
     */
    @Test
    public void testNonBulkItem() {
        final BigDecimal returnValue = myItem.calculateItemTotal(10);
        assertEquals(returnValue, new BigDecimal("3499.90"));
        assertEquals(myItem.isBulk(), false);
        
    }

    /**
     * Test that calculations for bulk items work correctly.
     * 10 sodas at $3.50/6-pack + $1/each for remaining 4 => 3.50 + 4 = 7.50
     * Also checks that isBulk is consistent
     */
    @Test
    public void testBulkItem() {
        final BigDecimal returnValue = myBulkItem.calculateItemTotal(10);
        assertEquals(returnValue, new BigDecimal("7.50"));
        assertEquals(myBulkItem.isBulk(), true);
    }

    /**
     * Test valid output of toString function for non-bulk item.
     */
    @Test
    public void testToStringNonBulk() {
        assertEquals("Peter's Xbox, $349.99", myItem.toString());
    }
    
    /**
     * Test valid output of toString function for bulk item.
     */
    @Test 
    public void testToStringBulk() {
        assertEquals(myBulkItem.toString(), "Soda, $1.00 (6 for $3.50)");
        
    }
    
    /**
     * Test equals methods, as well as hash code for consistency.
     */
    @Test
    public void testEqualsAndHashCode() {
        assertEquals(myBulkItem, myIdenticalBulkItem);
        assertEquals(myBulkItem.hashCode(), myIdenticalBulkItem.hashCode());
        assertNotEquals(myBulkItem, myItem);
    }
}
