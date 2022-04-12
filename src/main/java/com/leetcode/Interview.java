package main.java.com.leetcode;


import java.math.BigDecimal;
import java.util.*;

/**
 * @Author ZQQ
 * @Date 2021/5/5 9:37
 */
public class Interview {

    public static void main(String[] args) {
        List<Goods> goods = new ArrayList<>();
        Goods goods1 = new Goods("商品0", BigDecimal.valueOf(7.00), BigDecimal.valueOf(5), "供应商A", "嘉兴YX仓");
        Goods goods2 = new Goods("商品1", BigDecimal.valueOf(7.00), BigDecimal.valueOf(6), "供应商A", "余杭YX仓");
        Goods goods3 = new Goods("商品2", BigDecimal.valueOf(5.00), BigDecimal.valueOf(2), "供应商A", "余杭YX仓");
        Goods goods4 = new Goods("商品3", BigDecimal.valueOf(3.00), BigDecimal.valueOf(1), "供应商B", "嘉兴YX仓");
        Goods goods5 = new Goods("商品4", BigDecimal.valueOf(8.00), BigDecimal.valueOf(8), "供应商B", "嘉兴YX仓");
        goods.add(goods1);
        goods.add(goods2);
        goods.add(goods3);
        goods.add(goods4);
        goods.add(goods5);
        Map<String, List<Goods>> stringListMap = doPackage(goods);

    }

    public static Map<String, List<Goods>> doPackage(List<Goods> goods) {
        Map<String, List<Goods>> goodsListMap = new HashMap<>();
        if (goods == null || goods.size() == 0) {
            return goodsListMap;
        }
        // 分仓
        goods.forEach(p -> {
            if (null == goodsListMap.get(p.getWarehouse())) {
                List<Goods> goodsListTmp = new ArrayList<>();
                goodsListTmp.add(p);
                goodsListMap.put(p.getWarehouse(), goodsListTmp);
            } else {
                goodsListMap.get(p.getWarehouse()).add(p);
            }
        });

        goodsListMap.forEach((k, v) -> {
            Collections.sort(v, (o1, o2) -> {
                String a1 = o1.getSupplier() + " " + o1.getNum().multiply(o1.getPrice()).toPlainString();
                String a2 = o2.getSupplier() + " " + o2.getNum().multiply(o2.getPrice()).toPlainString();
                return a2.compareTo(a1);
            });

        });
        return goodsListMap;
    }


    static class Goods {
        private String name;

        private BigDecimal price;

        private BigDecimal num;

        private String supplier;

        private String warehouse;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public BigDecimal getNum() {
            return num;
        }

        public void setNum(BigDecimal num) {
            this.num = num;
        }

        public String getSupplier() {
            return supplier;
        }

        public void setSupplier(String supplier) {
            this.supplier = supplier;
        }

        public String getWarehouse() {
            return warehouse;
        }

        public void setWarehouse(String warehouse) {
            this.warehouse = warehouse;
        }

        public Goods(String name, BigDecimal price, BigDecimal num, String supplier, String warehouse) {
            this.name = name;
            this.price = price;
            this.num = num;
            this.supplier = supplier;
            this.warehouse = warehouse;
        }
    }
}
