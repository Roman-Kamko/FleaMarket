package com.team2.flea_market.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "size")
    private Long size;

    @Column(name = "media_type")
    private String mediaType;

    @Lob
    @Type(type = "binary")
    private byte[] content;

}
