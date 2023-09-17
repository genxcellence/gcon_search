package com.gcon.search.request;

import lombok.Data;

@Data
public class ContentRequest {
    private String content;
    private Long userId;
    private Long partyId;
    private Long documentId;
    private String documentName;
    private String status;
}
