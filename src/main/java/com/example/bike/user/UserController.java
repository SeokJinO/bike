package com.example.bike.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/list")
    public List<UserEntity> userList() {

        return userRepository.findAll();
    }
    // {seq}해당 유저 조회
    @GetMapping("/{seq}")
    public Optional<UserEntity> user(@PathVariable(name = "seq") Integer seq) {
        Optional<UserEntity> user = userRepository.findById(seq);
        return user;
    }
    // 유저 생성
    @PostMapping("")
    public String insertUser(@RequestBody UserEntity user) {
        userRepository.save(user);
        return "유저 생성 완료";
    }
    // 유저 삭제
    @DeleteMapping("/{seq}")
    public String deleteUser(@PathVariable(name = "seq") Integer seq) {
        userRepository.deleteById(seq);
        return "유저 삭제 완료";
    }

    // 유저 수정
    @PutMapping("")
    public String updateUser(@RequestBody UserEntity u) {
        if(u.getSeq() != null) {
            Optional<UserEntity> oUser = userRepository.findById(u.getSeq());
            if(oUser.isEmpty()) {
                return "존재하지 않는 아이디";
            }
            UserEntity user = oUser.get();
            user.setPw(u.getPw());
            user.setAddr(u.getAddr());
            user.setPhone(u.getPhone());
            userRepository.save(user);
            return "수정 완료";
        } else {
            return "수정 실패";
        }

    }

}
