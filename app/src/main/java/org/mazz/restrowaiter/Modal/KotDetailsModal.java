package org.mazz.restrowaiter.Modal;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.sql.Date;

public class KotDetailsModal {

    @SerializedName("kotPckey")
    private int kotPckey;
    @SerializedName("kotNo")
    private String kotNo;
    @SerializedName("kotDate")
    private String kotDate;
    @SerializedName("unqNo")
    private int unqNo;
    @SerializedName("itemPckey")
    private int itemPckey;
    @SerializedName("itemCode")
    private String itemCode;
    @SerializedName("itemName")
    private String itemName;
    @SerializedName("quantity")
    private BigDecimal quantity;
    @SerializedName("rate")
    private BigDecimal rate;
    @SerializedName("taxRate")
    private BigDecimal taxRate;
    @SerializedName("taxAmount")
    private BigDecimal taxAmount;
    @SerializedName("amount")
    private BigDecimal amount;
    @SerializedName("status")
    private String status;
    @SerializedName("discount")
    private BigDecimal discount;
    @SerializedName("reason")
    private String reason;
    @SerializedName("preferencePckey")
    private int preferencePckey;
    @SerializedName("printed")
    private int printed;
    @SerializedName("pref")
    private String pref;

    public int getKotPckey() {
        return kotPckey;
    }

    public void setKotPckey(int kotPckey) {
        this.kotPckey = kotPckey;
    }

    public String getKotNo() {
        return kotNo;
    }

    public void setKotNo(String kotNo) {
        this.kotNo = kotNo;
    }

    public String getKotDate() {
        return kotDate;
    }

    public void setKotDate(String kotDate) {
        this.kotDate = kotDate;
    }

    public int getUnqNo() {
        return unqNo;
    }

    public void setUnqNo(int unqNo) {
        this.unqNo = unqNo;
    }

    public int getItemPckey() {
        return itemPckey;
    }

    public void setItemPckey(int itemPckey) {
        this.itemPckey = itemPckey;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getPreferencePckey() {
        return preferencePckey;
    }

    public void setPreferencePckey(int preferencePckey) {
        this.preferencePckey = preferencePckey;
    }

    public int getPrinted() {
        return printed;
    }

    public void setPrinted(int printed) {
        this.printed = printed;
    }

    public String getPref() {
        return pref;
    }

    public void setPref(String pref) {
        this.pref = pref;
    }
}
