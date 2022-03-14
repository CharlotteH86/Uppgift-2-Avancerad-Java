package com.company;

public class ListCsv {

    private String OrderDate="";
    private String Region="";
    private String Rep1="";
    private String Rep2="";
    private String Item="";
    private String Units="";
    private String UnitCost="";
    private String Total="";


    public ListCsv(String csv){
        super();

        if (csv.split(",").length<8){
            if (csv.charAt(0)==','){
                this.Region = csv.split(",")[1];
                this.Rep1 = csv.split(",")[2];
                this.Rep2 = csv.split(",")[3];
                this.Item = csv.split(",")[4];
                this.Units = csv.split(",")[5];
                this.UnitCost = csv.split(",")[6];
                this.Total = csv.split(",")[7];
            } else if (csv.charAt(csv.length() - 1) == ',') {
                this.OrderDate = csv.split(",")[0];
                this.Region = csv.split(",")[1];
                this.Rep1 = csv.split(",")[2];
                this.Rep2 = csv.split(",")[3];
                this.Item = csv.split(",")[4];
                this.Units = csv.split(",")[5];
                this.UnitCost = csv.split(",")[6];
            } else {
                //kod som känner av om en cell är tom
                boolean checker = false;
                int counter = 0;
                for (int i = 0; i < csv.length(); i++) {
                    System.out.println(counter);
                    if (csv.charAt(i) == ',') {
                        if (checker) {
                            break;
                        } else {
                            checker = true;
                            counter++;
                        }
                    } else {
                        checker = false;
                    }
                }

            }

            //kod som sorterar ifall en cell innehåller ett komma = ','
        } else if (csv.split(",").length > 8) {
            this.OrderDate = csv.split(",")[0];
            this.Region = csv.split(",")[1];
            this.Rep1 = csv.split(",")[2];
            this.Rep2 = csv.split(",")[3];
            this.Item = csv.split(",")[4];
            this.Units = csv.split(",")[5];
            this.UnitCost = csv.split(",")[6];
            this.Total = csv.split(",")[7] + "," + csv.split(",")[8];
        } else {
            this.OrderDate = csv.split(",")[0];
            this.Region = csv.split(",")[1];
            this.Rep1 = csv.split(",")[2];
            this.Rep2 = csv.split(",")[3];
            this.Item = csv.split(",")[4];
            this.Units = csv.split(",")[5];
            this.UnitCost = csv.split(",")[6];
            this.Total = csv.split(",")[7];
        }
    }


    // setters och getters
    public String get() {
        return OrderDate + "," + Region + "," + Rep1 + "," + Rep2 + "," + Item + "," + Units + "," + UnitCost
                + "," + Total;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getRep1() {
        return Rep1;
    }

    public void setRep1(String rep1) {
        Rep1 = rep1;
    }

    public String getRep2() {
        return Rep2;
    }

    public void setRep2(String rep2) {
        Rep2 = rep2;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getUnits() {
        return Units;
    }

    public void setUnits(String units) {
        Units = units;
    }

    public String getUnitCost() {
        return UnitCost;
    }

    public void setUnitCost(String unitCost) {
        UnitCost = unitCost;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }
}