package com.example.phudao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonResponse {

    @Id
    private Integer id;

    private Date ngaySua;

    private String trangThai;

    private String hoTen;
}
