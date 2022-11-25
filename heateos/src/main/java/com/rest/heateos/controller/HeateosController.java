package com.rest.heateos.controller;

import com.rest.heateos.entities.VideosEntity;
import com.rest.heateos.entities._LinksEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeateosController {
    public VideosEntity hyperMedia() {
        return new VideosEntity();
    }
}
