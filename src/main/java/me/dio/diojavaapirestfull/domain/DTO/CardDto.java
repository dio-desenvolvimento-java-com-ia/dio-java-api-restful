package me.dio.diojavaapirestfull.domain.DTO;

import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link me.dio.diojavaapirestfull.domain.model.Card}
 */
@Value
public class CardDto implements Serializable {
    String number;
    BigDecimal limit;
}