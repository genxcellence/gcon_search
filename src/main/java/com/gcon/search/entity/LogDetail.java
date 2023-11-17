package com.gcon.search.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "log_detail_index")
public class LogDetail {
    @Id
    private String id;
    private Long userId;
    private String logMessage;
}