package com.gcon.search.service;

import com.gcon.search.entity.Content;
import com.gcon.search.request.ContentRequest;
import com.gcon.search.request.SearchRequest;
import com.gcon.search.response.SearchResponse;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IElasticSearchService {

  Content addTemplateContent(ContentRequest request);

  List<Content> searchContent(String searchTerm);

  Content deleteContent(String contentValue);

  Content updateContent(String content,String id,Long userId) throws Exception;

  SearchResponse searchContent(SearchRequest request) throws Exception;


  String getUpdateStatus(Long documentId);
}
