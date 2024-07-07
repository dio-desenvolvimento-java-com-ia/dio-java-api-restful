package me.dio.diojavaapirestfull.service.imp;

import me.dio.diojavaapirestfull.domain.model.Account;
import me.dio.diojavaapirestfull.domain.model.User;
import me.dio.diojavaapirestfull.domain.repository.UserRepositoryI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.IllegalFormatException;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {

    @InjectMocks
    private UserServiceImp userServiceImp;

    @Mock
    private UserRepositoryI userRepositoryI;

    private User user;

    private Account account;

    private Optional<User> optionalUser;

    @Captor
    private ArgumentCaptor<User> userSavedCaptor;

    private final Long ID = 1L;

    @BeforeEach
    void setUp(){
        user = new User();
        user.setId(ID);
        account = new Account();
        account.setNumber("lksjsdklf8r34985903098095778");
        user.setAccount(account);
        optionalUser = Optional.of(user);

    }

    @Test
    @DisplayName("When find by id then return a user")
    void findByIdSucess() {
        when(userRepositoryI.findById(anyLong())).thenReturn(optionalUser);
        User response = userServiceImp.findById(ID);
        assertNotNull(response);
        assertEquals(ID, response.getId());
        verify(userRepositoryI, times(1)).findById(anyLong());

    }

    @Test
    @DisplayName("When find by id and the return is null then throw a exception")
    void findByIdError() {
        when(userRepositoryI.findById(anyLong())).thenReturn(Optional.empty());
        NoSuchElementException thrown = assertThrows(
                NoSuchElementException.class,
                () -> userServiceImp.findById(anyLong())
        );
        assertEquals(NoSuchElementException.class, thrown.getClass());
        verify(userRepositoryI, times(1)).findById(anyLong());
    }

    @Test
    @DisplayName("If user account number exists then save user")
    void createSuccess() {
        when(userRepositoryI.existsByAccountNumber(anyString())).thenReturn(false);
        when(userRepositoryI.save(any(User.class))).thenReturn(user);
        userServiceImp.create(user);
        verify(userRepositoryI).save(userSavedCaptor.capture());
        User response = userSavedCaptor.getValue();
        assertNotNull(response);
        verify(userRepositoryI, times(1)).save(any(User.class));
        assertEquals(ID, response.getId());
        assertEquals(Account.class, response.getAccount().getClass());
    }

    @Test
    @DisplayName("If user account number not exists then throw exception")
    void createError() {
        when(userRepositoryI.existsByAccountNumber(anyString())).thenReturn(true);
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> userServiceImp.create(user)
        );
        assertEquals(IllegalArgumentException.class, thrown.getClass());
        assertEquals("This account number already exists!", thrown.getMessage());
        verify(userRepositoryI, times(0)).save(any(User.class));
    }
}