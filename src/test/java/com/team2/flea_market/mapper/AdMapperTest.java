package com.team2.flea_market.mapper;

import com.team2.flea_market.dto.ad.AdDto;
import com.team2.flea_market.dto.ad.CreateOrUpdateAdDto;
import com.team2.flea_market.entity.Ad;
import com.team2.flea_market.entity.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AdMapperTest {
    private final AdMapper mapper = new AdMapperImpl();

    private final Ad ad = prepearNewAd();

    private final AdDto dto = prepearNewAdDto();

    private final CreateOrUpdateAdDto createOrUpdateAdDto = prepaerUpdateDto();

    @Test
    void toEntityTest() {
        assertThat(mapper.toEntity(dto)).isEqualTo(ad);
    }

    @Test
    void createOrUpdateAdTest() {
        assertThat(mapper.createOrUpdateAd(createOrUpdateAdDto, ad).getTitle()).isEqualTo(createOrUpdateAdDto.title());
        assertThat(mapper.createOrUpdateAd(createOrUpdateAdDto, ad).getDescription()).isEqualTo(createOrUpdateAdDto.description());
        assertThat(mapper.createOrUpdateAd(createOrUpdateAdDto, ad).getPrice()).isEqualTo(createOrUpdateAdDto.price());
    }

    @Test
    void toDtoTest() {
        assertThat(mapper.toDto(ad)).isEqualTo(dto);
    }

    private Ad prepearNewAd() {
        Ad ad = new Ad();
        ad.setId(1);
        ad.setTitle("title");
        ad.setDescription(null);
        ad.setComment(null);
        ad.setImage("image");
        ad.setPrice(200);
        ad.setUser(User.builder().id(2).build());
        return ad;
    }

    private AdDto prepearNewAdDto() {
        AdDto adDto = new AdDto(2, "image", 1, 200, "title");
        return adDto;
    }

    private CreateOrUpdateAdDto prepaerUpdateDto() {
        CreateOrUpdateAdDto createOrUpdateAdDto = new CreateOrUpdateAdDto("new_title", 300, "desc");
        return createOrUpdateAdDto;
    }
}