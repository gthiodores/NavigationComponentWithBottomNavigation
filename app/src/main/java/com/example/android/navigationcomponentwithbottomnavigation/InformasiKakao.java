package com.example.android.navigationcomponentwithbottomnavigation;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

@Parcel(Parcel.Serialization.BEAN)
public class InformasiKakao {
    private String judulInformasi;
    private int gambarInformasi;
    private String isiInformasi;

    InformasiKakao() {

    }

    @ParcelConstructor
    InformasiKakao(String judulInformasi, int gambarInformasi, String isiInformasi) {
        setIsiInformasi(isiInformasi);
        setJudulInformasi(judulInformasi);
        setGambarInformasi(gambarInformasi);
    }

    public String getJudulInformasi() {
        return judulInformasi;
    }

    public void setJudulInformasi(String judulInformasi) {
        this.judulInformasi = judulInformasi;
    }

    public int getGambarInformasi() {
        return gambarInformasi;
    }

    public void setGambarInformasi(int gambarInformasi) {
        this.gambarInformasi = gambarInformasi;
    }

    public String getIsiInformasi() {
        return isiInformasi;
    }

    public void setIsiInformasi(String isiInformasi) {
        this.isiInformasi = isiInformasi;
    }

}
