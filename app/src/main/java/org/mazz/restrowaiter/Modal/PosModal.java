package org.mazz.restrowaiter.Modal;

import com.google.gson.annotations.SerializedName;

public class PosModal {

    @SerializedName("posCode")
    private int posCode;

    public PosModal(int posCode, String posName) {
        this.posCode = posCode;
        this.posName = posName;
    }

    @SerializedName("posName")
    private String posName;

    public PosModal() {
    }

    public int getPosCode() {
        return posCode;
    }

    public void setPosCode(int posCode) {
        this.posCode = posCode;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }
}
