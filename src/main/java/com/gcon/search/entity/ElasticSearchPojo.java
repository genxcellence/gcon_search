package com.gcon.search.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ElasticSearchPojo {

    private String contactName;
    private Long documentId;
    private String documentContent;
    private Long partyId;
    private Long userId;

    public ElasticSearchPojo(String contactName, Long documentId, String documentContent, Long partyId, Long userId) {
        this.contactName = contactName;
        this.documentId = documentId;
        this.documentContent = documentContent;
        this.partyId = partyId;
        this.userId = userId;
    }

}
