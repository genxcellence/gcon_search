package com.gcon.search.request;

import lombok.Data;

@Data
public class ContentRequest {
    private String content;
    private Long userId;
    private Long partyId;
}
