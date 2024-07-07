package me.dio.diojavaapirestfull.controller;

import me.dio.diojavaapirestfull.domain.DTO.IdResponse;
import me.dio.diojavaapirestfull.domain.DTO.UserReqRespDto;
import me.dio.diojavaapirestfull.domain.model.User;
import me.dio.diojavaapirestfull.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<UserReqRespDto> findById(@PathVariable Long id){
        User user = userService.findById(id);
        return ResponseEntity.ok(modelMapper.map(user, UserReqRespDto.class));
    }

    @PostMapping
    public ResponseEntity<IdResponse> create(@RequestBody UserReqRespDto userReqRespDto){
        User user = modelMapper.map(userReqRespDto, User.class);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        user = userService.create(user);
        return ResponseEntity.created(uri).body(
                modelMapper.map(user, IdResponse.class)
        );
    }

}
