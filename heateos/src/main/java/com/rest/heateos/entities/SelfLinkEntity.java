package com.rest.heateos.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SelfLinkEntity {
    private String href;

    @Override
    public String toString() {
        return "self: " + "{" +
                "href: '" + href + '\'' +
                '}';
    }
}
