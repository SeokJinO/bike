package com.example.bike.bike;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/bike")
public class BikeController {

    private final BikeRepository bikeRepository;

    @GetMapping("/list")
    public List<BikeEntity> BikeList() {
        List<BikeEntity> bikeList = bikeRepository.findAll();
        return bikeList;
    }

    @GetMapping("/{seq}")
    public Optional<BikeEntity> bike(@PathVariable(name = "seq") int seq) {
        Optional<BikeEntity> bike = bikeRepository.findById(seq);
        return bike;
    }

    @PostMapping("")
    public String insertBike(@RequestBody BikeEntity bike) {
        bikeRepository.save(bike);
        return "생성 완료";
    }

    @PutMapping("")
    public String updateBike(@RequestBody BikeEntity b) {
        if(b.getSeq() != null) {
            Optional<BikeEntity> oBike = bikeRepository.findById(b.getSeq());
            BikeEntity bike = oBike.get();
            bike.setLocation(b.getLocation());
            bikeRepository.save(bike);
            return "수정 완료";
        } else {
            return "수정 실패";
        }
    }
}
