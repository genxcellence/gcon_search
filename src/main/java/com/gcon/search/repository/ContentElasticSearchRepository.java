package com.gcon.search.repository;

import com.gcon.search.entity.Content;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContentElasticSearchRepository extends ElasticsearchRepository<Content,String> {

   // Content findByContent(String content);

   List<Content> findByContent(String content);

   Optional<Content> findByDocumentIdAndUserId(String id,Long userId);

   List<Content> findFirst5ByUserIdAndPartyIdAndContent(Long userId, Long partyId,String content);

   List<Content> findAllByUserIdAndPartyIdAndContent(Long userId, Long partyId,String content);

   Long countAllByUserIdAndPartyIdAndContent(Long userId, Long partyId, String searchString);

   Optional<Content> findByDocumentId(Long id);

   List<Content> findFirst5ByPartyIdAndContent(Long partyId,String content);

   List<Content> findAllByPartyIdAndContent(Long partyId,String content);

   Long countAllByPartyIdAndContent(Long partyId,String searchString);


}
