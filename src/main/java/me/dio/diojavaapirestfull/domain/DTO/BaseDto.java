package me.dio.diojavaapirestfull.domain.DTO;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link me.dio.diojavaapirestfull.domain.model.News}
 */
@Value
public class BaseDto implements Serializable {
    String icon;
    String description;
}