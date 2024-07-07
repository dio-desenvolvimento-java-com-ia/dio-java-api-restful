package me.dio.diojavaapirestfull.controller;

import me.dio.diojavaapirestfull.domain.DTO.IdResponse;
import me.dio.diojavaapirestfull.domain.DTO.UserReqRespDto;
import me.dio.diojavaapirestfull.domain.model.User;
import me.dio.diojavaapirestfull.service.UserService;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private ModelMapper modelMapper;

    private final Long ID = 1L;

    private User user;

    private UserReqRespDto userReqRespDto;

    private IdResponse idResponse;



    @BeforeEach
    void setUp() {
        user = new User();
        userReqRespDto = new UserReqRespDto();
        user.setId(ID);
        idResponse = new IdResponse();
    }

    @Test
    void findById() {
        when(userService.findById(anyLong())).thenReturn(user);
        when(modelMapper.map(any(), any())).thenReturn(userReqRespDto);
        ResponseEntity<UserReqRespDto> response = userController.findById(ID);
        assertNotNull(response);
        assertEquals(HttpStatus.OK.value(), response.getStatusCode().value());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(UserReqRespDto.class, response.getBody().getClass());
    }

    @Test
    void create() {
        when(modelMapper.map(any(), eq(User.class))).thenReturn(user);
        when(modelMapper.map(any(), eq(IdResponse.class))).thenReturn(idResponse);
        when(userService.create(any(User.class))).thenReturn(user);
        ResponseEntity<IdResponse> response = userController.create(userReqRespDto);
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(IdResponse.class, response.getBody().getClass());



    }
}