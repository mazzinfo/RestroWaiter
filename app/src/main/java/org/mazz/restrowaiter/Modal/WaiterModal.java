package org.mazz.restrowaiter.Modal;

import com.google.gson.annotations.SerializedName;

public class WaiterModal {

    @SerializedName("waiterNo")
    private long waiterNo;

    @SerializedName("waiterCode")
    private String waiterCode;

    @SerializedName("waiterName")
    private String waiterName;

    @SerializedName("poscode")
    private int posCode;

    @Override
    public String toString() {
        return "WaiterModal{" +
                "waiterNo=" + waiterNo +
                ", waiterCode='" + waiterCode + '\'' +
                ", waiterName='" + waiterName + '\'' +
                ", posCode=" + posCode +
                '}';
    }

    public long getWaiterNo() {
        return waiterNo;
    }

    public void setWaiterNo(long waiterNo) {
        this.waiterNo = waiterNo;
    }

    public String getWaiterCode() {
        return waiterCode;
    }

    public void setWaiterCode(String waiterCode) {
        this.waiterCode = waiterCode;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public int getPosCode() {
        return posCode;
    }

    public void setPosCode(int posCode) {
        this.posCode = posCode;
    }
}
