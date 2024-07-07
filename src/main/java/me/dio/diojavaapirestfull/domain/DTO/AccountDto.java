package me.dio.diojavaapirestfull.domain.DTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link me.dio.diojavaapirestfull.domain.model.Account}
 */
@Getter
@Setter
public class AccountDto implements Serializable {
    String number;
    String agency;
    BigDecimal balance;
    BigDecimal limit;
}