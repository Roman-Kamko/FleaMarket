package com.team2.flea_market.controller;

import com.team2.flea_market.dto.ad.AdDto;
import com.team2.flea_market.dto.ad.AdsDto;
import com.team2.flea_market.dto.ad.CreateOrUpdateAdDto;
import com.team2.flea_market.dto.ad.ExtendedAdDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.Collections;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
@Tag(name = "Объявления")
public class AdController {

    @Operation(summary = "Получение всех объявлений")
    @ApiResponse(responseCode = "200", description = "OK", content = {
            @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema =
            @Schema(implementation = AdsDto.class))})
    @GetMapping
    public ResponseEntity<AdsDto> findAllAds() {
        return ResponseEntity.ok(new AdsDto(0, Collections.emptyList()));
    }

    @Operation(summary = "Добавление объявления")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema =
                    @Schema(implementation = AdDto.class))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(schema = @Schema(hidden = true))})
    })
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AdDto> createAd(@RequestPart(value = "properties") @Valid CreateOrUpdateAdDto createOrUpdateAdDto,
                                          @RequestPart(value = "image") MultipartFile image) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new AdDto(1, "", 1, 1, ""));
    }

    @Operation(summary = "Добавление объявления")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema =
                    @Schema(implementation = ExtendedAdDto.class))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(schema = @Schema(hidden = true))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = {
                    @Content(schema = @Schema(hidden = true))})
    })
    @GetMapping("/{id}")
    public ResponseEntity<ExtendedAdDto> findAdById(@PathVariable @Parameter(description = "id объявления") Integer id) {
        return ResponseEntity.ok(new ExtendedAdDto(1, "", "", "", "", "", "", 1, ""));
    }

    @Operation(summary = "Удаление объявления")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content", content = {
                    @Content(schema = @Schema(hidden = true))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(schema = @Schema(hidden = true))}),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = {
                    @Content(schema = @Schema(hidden = true))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = {
                    @Content(schema = @Schema(hidden = true))})
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAd(@PathVariable @Parameter(description = "id объявления") Integer id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "Обновление информации об объявлении")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema =
                    @Schema(implementation = AdDto.class))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(schema = @Schema(hidden = true))}),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = {
                    @Content(schema = @Schema(hidden = true))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = {
                    @Content(schema = @Schema(hidden = true))})
    })
    @PatchMapping("/{id}")
    public ResponseEntity<AdDto> updateAd(@PathVariable @Parameter(description = "id объявления") Integer id,
                                          @RequestBody @Valid CreateOrUpdateAdDto createOrUpdateAdDto) {
        return ResponseEntity.ok(new AdDto(1, "", 1, 1, ""));
    }

    @Operation(summary = "Обновление информации об объявлении")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema =
                    @Schema(implementation = AdDto.class))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(schema = @Schema(hidden = true))})
    })
    @GetMapping("/me")
    public ResponseEntity<AdsDto> findAllUserAds() {
        return ResponseEntity.ok(new AdsDto(0, Collections.emptyList()));
    }

    @Operation(summary = "Обновление картинки объявления")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                    @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM_VALUE, array =
                    @ArraySchema(schema = @Schema(type = "string", format = "byte")))}),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                    @Content(schema = @Schema(hidden = true))}),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = {
                    @Content(schema = @Schema(hidden = true))}),
            @ApiResponse(responseCode = "404", description = "Not found", content = {
                    @Content(schema = @Schema(hidden = true))})
    })
    @PatchMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> updateAdImage(@PathVariable @Parameter(description = "id объявления") Integer id,
                                                @RequestPart MultipartFile image) {
        return ResponseEntity.ok(new byte[]{});
    }

}
