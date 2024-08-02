package com.example.phudao.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class HoaDonRequesr {

    @NonNull
    private String diaChi;

    @NonNull
    @NotBlank(message = "trang thai dang khong dung")
    private String trangThai;

    @Override
    public String toString() {
        return "HoaDonRequesr{" +
                "diaChi='" + diaChi + '\'' +
                ", trangThai='" + trangThai + '\'' +
                '}';
    }
}
