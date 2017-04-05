/*
 * TCSS 305 – Autumn 2015
 * Assignment 2 – ItemOrder class for shoppingCart project 
 */

package model;

import java.math.BigDecimal;

/**
 * ItemOrder class stores information about the purchase order: item and quantity. 
 * @author Sophie Nop
 * @version 17 October 2015
 */
public final class ItemOrder {

    /**
     * The quantity of the items. 
     */
    private final int myQuantity; 

    /**
     * My items. 
     */
    private final Item myItem; 

    /**
     * @param theItem take in the item as an Item object.
     * @param theQuantity takes in the quantity as an integer. 
     */
    public ItemOrder(final Item theItem, final int theQuantity) {
        if (theQuantity < 0) {
            throw new IllegalArgumentException();
        }
        myQuantity = theQuantity; 
        myItem = theItem; 
    }

    /**
     * @return the cost for the item order as a BigDecimal.
     */
    public BigDecimal calculateOrderTotal() {
        return myItem.calculateItemTotal(myQuantity);
    }

    /**
     * @return a reference to the Item in the ItemOrder. 
     */
    public Item getItem() {
        return myItem; 
    }

    /**
     * @return the quantity for the ItemOrder. 
     */
    public int getQuantity() {
        return myQuantity;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     * @return a String representation of the ItemOrder. 
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(myQuantity).append(' ').append(myItem.toString());
        return sb.toString();
    }

}
