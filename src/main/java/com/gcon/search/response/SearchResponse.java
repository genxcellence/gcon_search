package com.gcon.search.response;

import com.gcon.search.entity.Content;
import com.gcon.search.entity.ElasticSearchPojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponse {
    private Long totalCount;
    private List<Content> documents;
}
