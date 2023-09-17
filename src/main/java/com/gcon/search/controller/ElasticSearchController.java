package com.gcon.search.controller;

import com.gcon.search.entity.Content;
import com.gcon.search.request.ContentRequest;
import com.gcon.search.request.SearchRequest;
import com.gcon.search.response.SearchResponse;
import com.gcon.search.service.IElasticSearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/search")
public class ElasticSearchController {

    @Autowired
    IElasticSearchService service;

    @PostMapping("/template-content")
    public ResponseEntity<Content> addTemplateContent(@RequestBody ContentRequest request) {
        return new ResponseEntity<>(service.addTemplateContent(request), HttpStatus.OK);

    }

    @GetMapping("/search-content/{searchTerm}")
    public ResponseEntity<List<Content>> searchContent(@PathVariable String searchTerm) {
        return new ResponseEntity<>(service.searchContent(searchTerm), HttpStatus.OK);
    }

    @DeleteMapping("/delete-content")
    public ResponseEntity<Content> deleteContent(@RequestParam String contentValue) {
        return new ResponseEntity<>(service.deleteContent(contentValue), HttpStatus.OK);
    }

    @PostMapping("/search-documents")
    public ResponseEntity<SearchResponse> getSearchDocuments(@RequestBody SearchRequest request) throws Exception {
        return new ResponseEntity<>(service.searchContent(request), HttpStatus.OK);

    }


  /*  @PutMapping("/update-content")
    public ResponseEntity<Content> updateContent(@RequestBody Content request) throws Exception {
        return new ResponseEntity<>(service.updateContent(request), HttpStatus.OK);
    }*/
    @PutMapping("/update-content/{id}/{userId}")
    public ResponseEntity<Content> updateContent(@RequestBody String Content,@PathVariable String id,@PathVariable Long userId,@RequestParam String status) throws Exception {
        return new ResponseEntity<>(service.updateContent(Content,id,userId,status), HttpStatus.OK);
    }
}
