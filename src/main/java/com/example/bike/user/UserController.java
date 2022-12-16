package com.example.bike.user;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserController {

    private final UserRepository userRepository;
    private EntityManager em;
    private EntityTransaction tx = em.getTransaction();

    @GetMapping("/list")
    public List<UserEntity> userList() {

        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserEntity> user(@PathVariable(name = "id") int id) {
        Optional<UserEntity> user = userRepository.findById(id);
        return user;
    }
    @PostMapping("")
    public String insertUser(@RequestBody UserEntity user) {
        userRepository.save(user);
        return "유저 생성 완료";
    }

    @DeleteMapping("/{id}")
    @Transactional
    public String deleteUser(@PathVariable(name = "id") int id) {
        userRepository.deleteById(id);
        return "유저 삭제 완료";
    }

    @PutMapping("")
    public String updateUser(@RequestBody UserEntity userEntity) {
        tx.begin();
        UserEntity user = em.find(UserEntity.class, userEntity.getId());
        user.setPw(userEntity.getPw());
        user.setAddr(userEntity.getAddr());
        user.setPhone(userEntity.getPhone());
        tx.commit();
        em.close();
        return "수정 완료";
    }

}
