package ua.nure.uvarov.entity;

import java.util.Date;

public class PenaltyOrders {
    private int id;
    private int penaltyid;
    private int orderid;
    private double debt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPenaltyid() {
        return penaltyid;
    }

    public void setPenaltyid(int penaltyid) {
        this.penaltyid = penaltyid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;
}
