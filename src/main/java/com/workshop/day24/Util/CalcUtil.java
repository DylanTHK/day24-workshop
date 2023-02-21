package com.workshop.day24.Util;

import java.util.List;

import com.workshop.day24.model.LineItem;
import com.workshop.day24.model.Order;

public class CalcUtil {
    
    public static Float calculateTotalPrice(Order o) {
        List<LineItem> li = o.getLineItems();

        Float total = 0f;

        for (LineItem i : li) {
            total += i.getUnitPrice() * i.getQuantity();
        }

        return total;
    }
}
