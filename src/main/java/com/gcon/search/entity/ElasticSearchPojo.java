package com.gcon.search.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ElasticSearchPojo {

    private String documentName;
    private Long documentId;
    private String documentContent;
    private Long partyId;
    private Long userId;

    public ElasticSearchPojo(String contactName, Long documentId, String documentContent, Long partyId, Long userId) {
        this.documentName = contactName;
        this.documentId = documentId;
        this.documentContent = documentContent;
        this.partyId = partyId;
        this.userId = userId;
    }

}
