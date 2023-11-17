package com.gcon.search.repository;

import com.gcon.search.entity.LogDetail;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogDetailRepository extends ElasticsearchRepository<LogDetail,String>{

   List<LogDetail> findByUserId(Long userId);
   List<LogDetail> getLogsByUserId(Long userId);
}
