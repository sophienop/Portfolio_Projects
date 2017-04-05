/*
 * TCSS 305 – Autumn 2015 
 * Assignment 2 – Item class for shoppingCart project
 */

package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author Sophie Nop
 * @version 16 October 2015
 */

public final class Item {
    
    /**
     * Number format for US dollars.
     */
    private static final NumberFormat US_DOLLARS_FORMAT =
                    NumberFormat.getCurrencyInstance(Locale.US);

    /**
     * The name of my item.
     */
    private final String myItemName;

    /**
     * The price of my item.
     */
    private final BigDecimal myItemPrice;

    /**
     * The bulk quantity.
     */
    private final int myBulkQuantity;

    /**
     * The price for bulk items.
     */
    private final BigDecimal myBulkPrice;

    /**
     * @param theItemName takes in the item name as a String argument.
     * @param theItemPrice takes in the price of the item as a BigDecimal.
     */
    public Item(final String theItemName, final BigDecimal theItemPrice) {
        // bulk quantity of one means no discount.        
        // myBulkPrice is set to the item price so that bulk and non bulk
        // calculations are equal.
        this(theItemName, theItemPrice, 1, theItemPrice);
    }

    /**
     * @param theItemName takes in the item name as a String argument.
     * @param theItemPrice takes in the price of the item as a BigDecimal.
     * @param theItemBulkQuantity takes in the bulk quantity as an integer.
     * @param theBulkPrice takes in the bulk price as a BigDecimal.
     */
    public Item(final String theItemName, final BigDecimal theItemPrice,
                final int theItemBulkQuantity, final BigDecimal theBulkPrice) {
        
        if (theItemName.isEmpty()
                        || theItemPrice.compareTo(BigDecimal.ZERO) < 0
                        || theItemBulkQuantity < 0
                        || theBulkPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException();
        }
        myItemName = theItemName;
        myItemPrice = theItemPrice;
        myBulkQuantity = theItemBulkQuantity;
        myBulkPrice = theBulkPrice;
    }

    /**
     * @param theItemQuantity is an integer.
     * @return the price as a BigDecimal.
     */
    public BigDecimal calculateItemTotal(final int theItemQuantity) {
        if (theItemQuantity < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal returnValue;
        if (this.isBulk()) {
            // bulk case: calculate bulk rate and single rate separately, then
            // add together and return them
            final BigDecimal bulkPacksToPurchase =
                            new BigDecimal(theItemQuantity / myBulkQuantity);
            final BigDecimal singleItemsToPurchase =
                            new BigDecimal(theItemQuantity % myBulkQuantity);
            final BigDecimal bulkItemsPrice = bulkPacksToPurchase.multiply(myBulkPrice);
            final BigDecimal singleItemsPrice = singleItemsToPurchase.multiply(myItemPrice);
            returnValue = bulkItemsPrice.add(singleItemsPrice);
        } else {
            // non-bulk-rate case: only use single items
            final BigDecimal singleItemsToPurchase =
                            new BigDecimal(theItemQuantity);
            returnValue = singleItemsToPurchase.multiply(myItemPrice);
        }
        return returnValue;
    }

    /**
     * @return isBulk as true if the item has bulk pricing and false otherwise.
     */
    public boolean isBulk() {
        // if myItemBulkQuantity is 1, there is no bulk discount
        return myBulkQuantity > 1;
    }

    /*
     * (non-Javadoc)
     * A string representation of the Item: name,price, bulk price
     * and bulk quanity and bulk price for bulk items. 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append(myItemName).append(", ").append(US_DOLLARS_FORMAT.format(myItemPrice));
        if (isBulk()) {
            sb.append(" (").append(myBulkQuantity).append(" for ");
            sb.append(US_DOLLARS_FORMAT.format(myBulkPrice)).append(')');
        }
        return sb.toString();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object theOther) {
        boolean isEqual = false; 
        // note - bug checker tells us "no need to check for null before instanceof"
        if (theOther instanceof Item) {
            final Item otherItem = (Item) theOther;

            if (myItemName.equals(otherItem.myItemName) 
                            && (myItemPrice.equals(otherItem.myItemPrice))
                            && myBulkQuantity == otherItem.myBulkQuantity 
                            && myBulkPrice.equals(otherItem.myBulkPrice)) {
                isEqual = true;
            }

        }
        return isEqual;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return myItemName.hashCode() * myItemPrice.hashCode() + myBulkQuantity
                        * myBulkPrice.hashCode();
    }

}
