package com.rest.heateos.entities;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class VideosEntity {
    private String name;
    private String Description;
    private _LinksEntity links;
}
