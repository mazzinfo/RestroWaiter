package org.mazz.restrowaiter.Modal;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class TableModal {

    @SerializedName("unqNo")
    private int unqNo;
    @SerializedName("tableNo")
    private String tableNo;
    @SerializedName("posCode")
    private int posCode;
    @SerializedName("tableStatus")
    private int tableStatus;
    @SerializedName("pax")
    private int pax;
    @SerializedName("sitTime")
    private String sitTime;
    @SerializedName("waiterNo")
    private int waiterNo;
    @SerializedName("waiterName")
    private String waiterName;
    @SerializedName("Discount")
    private int Discount;
    @SerializedName("sitActive")
    private String sitActive;
    @SerializedName("sitHour")
    private String sitHour;

    public int getUnqNo() {
        return unqNo;
    }

    public void setUnqNo(int unqNo) {
        this.unqNo = unqNo;
    }

    public String getTableNo() {
        return tableNo;
    }

    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }

    public int getPosCode() {
        return posCode;
    }

    public void setPosCode(int posCode) {
        this.posCode = posCode;
    }

    public int getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(int tableStatus) {
        this.tableStatus = tableStatus;
    }

    public int getPax() {
        return pax;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public String getSitTime() {
        return sitTime;
    }

    public void setSitTime(String sitTime) {
        this.sitTime = sitTime;
    }

    public int getWaiterNo() {
        return waiterNo;
    }

    public void setWaiterNo(int waiterNo) {
        this.waiterNo = waiterNo;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int discount) {
        Discount = discount;
    }

    public String getSitActive() {
        return sitActive;
    }

    public void setSitActive(String sitActive) {
        this.sitActive = sitActive;
    }

    public String getSitHour() {
        return sitHour;
    }

    public void setSitHour(String sitHour) {
        this.sitHour = sitHour;
    }

    public String getSitMin() {
        return sitMin;
    }

    public void setSitMin(String sitMin) {
        this.sitMin = sitMin;
    }

    public String getSit() {
        return sit;
    }

    public void setSit(String sit) {
        this.sit = sit;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    @SerializedName("sitMin")
    private String sitMin;
    @SerializedName("sit")
    private String sit;
    @SerializedName("totalAmount")
    private BigDecimal totalAmount;


}

