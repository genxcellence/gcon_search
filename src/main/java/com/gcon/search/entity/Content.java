package com.gcon.search.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "content")
public class Content {
    @Id
    private String id;
    private String content;
    private Long partyId;
    private Long userId;
    private Long documentId;
    private String documentName;
    private String status;
}
