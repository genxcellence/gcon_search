package com.gcon.search.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequest {
    private Long userId;
    private Long partyId;
    private String search;
    private Boolean fetchAll;
    private Boolean isAdmin;
}
