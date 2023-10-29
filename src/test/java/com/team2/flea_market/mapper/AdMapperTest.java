package com.team2.flea_market.mapper;

import com.team2.flea_market.dto.ad.AdDto;
import com.team2.flea_market.dto.ad.CreateOrUpdateAdDto;
import com.team2.flea_market.dto.ad.ExtendedAdDto;
import com.team2.flea_market.entity.Ad;
import com.team2.flea_market.entity.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AdMapperTest {
    private final AdMapper mapper = new AdMapperImpl();

    private final Ad ad = prepearAd();
    private final Ad newAd = prepearNewAd();
    private final AdDto dto = prepearNewAdDto();
    private final CreateOrUpdateAdDto createOrUpdateAdDto = new CreateOrUpdateAdDto("new_title", 300, "desc");
    private final ExtendedAdDto extendedAdDto = new ExtendedAdDto(1, "f", "l", "desc",
            "e", "image", "89969597", 300, "title");

    @Test
    void toEntityTest() {
        assertThat(mapper.toEntity(createOrUpdateAdDto)).isEqualTo(newAd);
    }

    @Test
    void toUpdateAdTest() {
        assertThat(mapper.toUpdateAd(createOrUpdateAdDto, ad).getTitle()).isEqualTo(createOrUpdateAdDto.title());
        assertThat(mapper.toUpdateAd(createOrUpdateAdDto, ad).getDescription()).isEqualTo(createOrUpdateAdDto.description());
        assertThat(mapper.toUpdateAd(createOrUpdateAdDto, ad).getPrice()).isEqualTo(createOrUpdateAdDto.price());
    }

    @Test
    void toDtoTest() {
        assertThat(mapper.toDto(ad)).isEqualTo(dto);
    }

    @Test
    void toExtendedAdDtoTest() {
        assertThat(mapper.toExtendedAdDto(ad)).isEqualTo(extendedAdDto);
    }

    private Ad prepearAd() {
        Ad ad = new Ad();
        ad.setId(1);
        ad.setTitle("title");
        ad.setDescription("desc");
        ad.setComment(null);
        ad.setImage("image");
        ad.setPrice(300);
        ad.setUser(User.builder().id(2)
                .firstName("f")
                .lastName("l")
                .email("e")
                .phone("89969597")
                .build());
        return ad;
    }

    private Ad prepearNewAd() {
        Ad ad = new Ad();
        ad.setId(null);
        ad.setTitle("new_title");
        ad.setDescription("desc");
        ad.setComment(null);
        ad.setImage(null);
        ad.setPrice(300);
        ad.setUser(null);
        return ad;
    }

    private AdDto prepearNewAdDto() {
        AdDto adDto = new AdDto(2, "image", 1, 300, "title");
        return adDto;
    }

}