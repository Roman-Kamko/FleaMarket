package com.team2.flea_market.mapper;

import com.team2.flea_market.dto.ad.AdDto;
import com.team2.flea_market.dto.ad.CreateOrUpdateAdDto;
import com.team2.flea_market.dto.ad.ExtendedAdDto;
import com.team2.flea_market.entity.Ad;
import com.team2.flea_market.entity.Image;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AdMapper {

    /**
     * Используй для маппинг в {@link Ad} при создании
     *
     * @param adDtoIn {@link AdDto}
     * @return {@link Ad}
     */
    Ad toEntity(CreateOrUpdateAdDto adDtoIn);

    /**
     * Используй для маппинга при апдейте в {@link Ad}
     *
     * @param adDto {@link CreateOrUpdateAdDto}
     * @param ad    {@link Ad}
     */
    void toUpdateAd(CreateOrUpdateAdDto adDto, @MappingTarget Ad ad);

    /**
     * Используй для маппинга в {@link AdDto}
     *
     * @param ad {@link Ad}
     * @return {@link AdDto}
     */
    @Mapping(target = "pk", source = "id")
    @Mapping(target = "author", source = "user.id")
    @Mapping(target = "image", source = "image", qualifiedByName = "imageMapping")
    AdDto toDto(Ad ad);

    /**
     * Используй для маппинга в {@link ExtendedAdDto}
     *
     * @param ad {@link Ad}
     * @return {@link ExtendedAdDto}
     */
    @Mapping(target = "pk", source = "id")
    @Mapping(target = "authorFirstName", source = "user.firstName")
    @Mapping(target = "authorLastName", source = "user.lastName")
    @Mapping(target = "image", source = "image", qualifiedByName = "imageMapping")
    ExtendedAdDto toExtendedAdDto(Ad ad);

    @Named("imageMapping")
    default String imageMapping(Image image) {
        if (image == null) {
            return null;
        }
        return "users/image/" + image.getId();
    }

}
