package org.starfleet.epsilonprimeshipyards.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
    public class FakeOrder {
        private List<ProductItem> products;

        public void addItem(ProductItem item){
            products.add(item);
        }
        public long itemTotalPrice(){
            long total = 0;
            for (ProductItem item : products) {
                total += item.getPrice();
            }
            return total;
        }

        public FakeOrder() {
            this.products = new ArrayList<>();
        }
    }

