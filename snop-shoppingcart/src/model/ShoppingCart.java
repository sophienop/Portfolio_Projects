/*
 * TCSS 305 � Autumn 2015 
 * Assignment 2 - ShoppingCart class for shoppingCart project.
 */

package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * This class stores information about the customer's overall purchase.
 * 
 * @author Sophie Nop
 * @version 17 Oct 2015
 */
public class ShoppingCart {

    /**
     * Customer with membership only pay 90%, a 10% discount.
     */
    private static final BigDecimal DISCOUNT_RATE = new BigDecimal("0.9");

    /**
     * Collection field used to hold information about all the Items. using list
     * is not recommended.
     */
    private final Map<Item, ItemOrder> myShoppingCartItems;

    /**
     * myMembershipStatus hold whether I am a member or not.
     */
    private boolean myMembershipStatus;

    /**
     * Constructor that creates an empty shopping cart.
     */
    public ShoppingCart() {
        myShoppingCartItems = new HashMap<Item, ItemOrder>();
        myMembershipStatus = false;
    }

    /**
     * add Method adds an order to the shopping cart, replacing any previous
     * order for an equivalent item with the new order.
     * 
     * @param theOrder adds an oder to the shopping cart.
     */
    public void add(final ItemOrder theOrder) {
        myShoppingCartItems.put(theOrder.getItem(), theOrder);
    }

    /**
     * Sets whether or not the customer for the shopping cart has a store
     * membership.
     * 
     * @param theMembership is boolean; true if the customer has membership.
     */
    public void setMembership(final boolean theMembership) {
        myMembershipStatus = theMembership;
    }

    /**
     * Returns the total cost of this shopping cart as a BigDecimal. This
     * returned BigDecimal should have scale of 2 and use the ROUND_HALF_EVEN
     * rounding rule.
     * 
     * @return the total price of the order.
     */
    public BigDecimal calculateTotal() {
        BigDecimal totalPrice = BigDecimal.ZERO; 
        for (final ItemOrder order : myShoppingCartItems.values()) {
            BigDecimal itemPrice = order.calculateOrderTotal();
            if (myMembershipStatus && !order.getItem().isBulk()) {
                itemPrice = itemPrice.multiply(DISCOUNT_RATE);
            }
            totalPrice = totalPrice.add(itemPrice);
        }
        return totalPrice.setScale(2, RoundingMode.HALF_EVEN);
    }

    /**
     * clear method clears all the items in the shopping cart. 
     */
    public void clear() {
        myShoppingCartItems.clear();
    }

    /*
     * (non-Javadoc)
     * toString creates a String representation of the ShoppingCart. 
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(myShoppingCartItems).append(calculateTotal());
        return sb.toString();
    }

}
