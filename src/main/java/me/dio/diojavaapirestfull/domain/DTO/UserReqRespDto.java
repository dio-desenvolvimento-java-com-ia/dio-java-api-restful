package me.dio.diojavaapirestfull.domain.DTO;

import lombok.Getter;
import lombok.Setter;
import me.dio.diojavaapirestfull.domain.model.Account;
import me.dio.diojavaapirestfull.domain.model.Card;
import me.dio.diojavaapirestfull.domain.model.Feature;
import me.dio.diojavaapirestfull.domain.model.News;

import java.util.List;

@Setter
@Getter
public class UserReqRespDto {
    private String name;
    private AccountDto account;
    private List<BaseDto> features;
    private CardDto card;
    private List<BaseDto> news;
}
