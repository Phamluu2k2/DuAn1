package com.example.phudao.repository;

import com.example.phudao.model.HoaDonResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface HoaDonResponseRepo extends JpaRepository<HoaDonResponse, Integer> {
    @Query(
            value = "SELECT  hd.id , hd.ngay_sua , hd.trang_thai , kh.ho_ten as ho_ten " +
                    " from hoa_don hd " +
                    " inner join khach_hang kh on hd .id_khach_hang  = kh.id"
            , nativeQuery = true
    )
    Page<HoaDonResponse> getAll(Pageable pageable);
}
