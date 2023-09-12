package com.gcon.search.service.impl;

import com.gcon.search.entity.Content;
import com.gcon.search.repository.ContentElasticSearchRepository;
import com.gcon.search.request.ContentRequest;
import com.gcon.search.request.SearchRequest;
import com.gcon.search.response.SearchResponse;
import com.gcon.search.service.IElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ElasticSearchService implements IElasticSearchService {

    @Autowired
    ContentElasticSearchRepository contentElasticSearchRepository;

    @Override
    public Content addTemplateContent(ContentRequest request) {
        Content templateContent = new Content();
        templateContent.setContent(request.getContent());
        templateContent.setPartyId(request.getPartyId());
        templateContent.setUserId(request.getUserId());
        return contentElasticSearchRepository.save(templateContent);
    }


    @Override
    public List<Content> searchContent(String searchTerm) {
        return contentElasticSearchRepository.findByContent(searchTerm);
    }

    @Override
    public Content deleteContent(String contentValue) {
        List<Content> contentList = contentElasticSearchRepository.findByContent(contentValue);
        for (Content content : contentList) {
            contentElasticSearchRepository.delete(content);
        }
        return new Content();
    }

    @Override
    public Content updateContent(String content,String id,Long userId) throws Exception {

        Optional<Content> existingContent = contentElasticSearchRepository.findByIdAndUserId(id,userId);
        if (existingContent.isEmpty()){
            throw new Exception("content not exist");
        }
        Content contentToUpdate = existingContent.get();
        contentToUpdate.setContent(content);
        Content updatedContent = contentElasticSearchRepository.save(contentToUpdate);
        return updatedContent;
    }

    @Override
    public SearchResponse searchContent(SearchRequest request) throws Exception {
        try{
           String searchString = "%"+request.getSearch()+"%";
           Long TotalRecord = contentElasticSearchRepository.countAllByUserIdAndPartyIdAndContentLike(request.getUserId(), request.getPartyId(), searchString);
            List<Content> documentRecords = new ArrayList<>();
            if(request.getFetchAll()){
                documentRecords = contentElasticSearchRepository.findAllByUserIdAndPartyIdAndContentLike(request.getUserId(), request.getPartyId(), searchString);
            }else{
                documentRecords = contentElasticSearchRepository.findFirst5ByUserIdAndPartyIdAndContentLike(request.getUserId(), request.getPartyId(), searchString);
            }
            return new SearchResponse(TotalRecord,documentRecords);
        }catch(Exception ex){
            throw ex;
        }
    }}




