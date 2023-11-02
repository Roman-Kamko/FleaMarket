package com.team2.flea_market.mapper;

import com.team2.flea_market.dto.auth.RegisterDto;
import com.team2.flea_market.dto.user.UpdateUserDto;
import com.team2.flea_market.dto.user.UserDto;
import com.team2.flea_market.entity.Image;
import com.team2.flea_market.entity.User;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    /**
     * Используй для маппинг в {@link User} при регистрации пользователя
     * @param registerDto {@link RegisterDto}
     * @return {@link User}
     */
    @Mapping(target = "email", source = "username")
    User toEntity(RegisterDto registerDto);

    /**
     * Используй для маппинга в {@link User} при обновлении полей firstName, lastName, phone
     * у пользователя
     * @param updateUserDto {@link UpdateUserDto}
     * @param user {@link User} к которому нужно применить изменения
     */
    void toUpdatedEntity(UpdateUserDto updateUserDto, @MappingTarget User user);

    /**
     * Используй для маппинга в {@link UserDto} при передаче данных пользователя клиенту
     * @param user {@link User}
     * @return {@link UserDto}
     */
    @Mapping(target = "image", source = "image", qualifiedByName = "imageMapping")
    UserDto toDto(User user);

    @Named("imageMapping")
    default String imageMapping(Image image) {
        if (image == null) {
            return null;
        }
        return "users/image/" + image.getId();
    }

}
