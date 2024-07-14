package org.example.app.payload;

import java.util.ArrayList;

/**
 * 2/19/2024
 * 2:33 PM
 */

public record Orders(String intent, ArrayList<PurchaseUnits>purchase_units) {
}
