package com.workshop.day24.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.workshop.day24.model.LineItem;
import com.workshop.day24.model.Order;

import static com.workshop.day24.repo.Queries.*;

import java.util.List;

@Repository
public class LineRepo {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // method to query sql for product information (without qty)
    public LineItem getProductByName(String name) {
        final LineItem li = new LineItem();
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_GET_PRODUCT_BY_NAME, name);

        if(rs.next()) {
            li.setProductName(rs.getString("prod_name"));
            li.setUnitPrice(rs.getFloat("prod_price"));
            li.setProductId(rs.getInt("prod_id"));
        }
        return li;
    }

    // 
    public void insertLineItems(Order order) {
        // get List of items from order object
        List<LineItem> li = order.getLineItems();
        // loop through items
        for (LineItem i : li) {
            // insert into line_item db with query
            jdbcTemplate.update(SQL_INSERT_LINE_ITEM, 
                i.getQuantity(),
                i.getProductId(),
                order.getOrderId());
        }

    }

}
