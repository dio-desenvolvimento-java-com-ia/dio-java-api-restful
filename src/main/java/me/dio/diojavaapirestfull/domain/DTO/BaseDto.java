package me.dio.diojavaapirestfull.domain.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link me.dio.diojavaapirestfull.domain.model.News}
 */
@Getter
@Setter
public class BaseDto implements Serializable {
    String icon;
    String description;
}