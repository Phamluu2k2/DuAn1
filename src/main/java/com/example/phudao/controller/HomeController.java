package com.example.phudao.controller;

import com.example.phudao.model.HoaDon;
import com.example.phudao.model.HoaDonRequesr;
import com.example.phudao.model.HoaDonResponse;
import com.example.phudao.repository.HoaDonRepository;
import com.example.phudao.repository.HoaDonResponseRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {

    //    public List
    @Autowired
    HoaDonRepository hoaDonRepository;
    @Autowired
    HoaDonResponseRepo hoaDonResponseRepo;
    @GetMapping("/hien-thi")
    public List<HoaDon> getAll() {
        return hoaDonRepository.findAll();
    }

    @GetMapping("/hien-thi/model")
    public Page<HoaDonResponse> get(Pageable pageable){
        return hoaDonResponseRepo.getAll(pageable);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@Valid @RequestBody HoaDonRequesr hoaDonRequesr){
        // dia chi, trang thai
        System.out.println(hoaDonRequesr);
        // cach 1 : insert = native query => Thoi
        // insert into hoadon(dia_chi, trang_thai) values (....)
        // cach 2 :
        // tao ra hoa don = new hoa don => set gia tri = request ???
        // goi ham save()
        return ResponseEntity.ok("ok");
    }

    @PutMapping("/update/{id}")
    public String update(
            @PathVariable("id") Integer id,
            @RequestBody HoaDon hoaDon){
        // kiem tra co id khong
        Optional<HoaDon> hoaDonDetail = hoaDonRepository.findById(id);
        if(!hoaDonDetail.isEmpty()){
            hoaDonDetail.get().setDiaChi(hoaDon.getDiaChi());
            hoaDonRepository.save(hoaDonDetail.get());
        }
        return "update thanh cong";
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id){
        hoaDonRepository.deleteById(id);
    }
}
