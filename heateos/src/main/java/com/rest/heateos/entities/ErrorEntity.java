package com.rest.heateos.entities;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class ErrorEntity {
    private String type;
    private String title;
    private int status;
    private String detail;
}
