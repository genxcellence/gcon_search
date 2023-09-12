package com.gcon.search.repository;

import com.gcon.search.entity.Content;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContentElasticSearchRepository extends ElasticsearchRepository<Content,String> {

   // Content findByContent(String content);

   List<Content> findByContent(String content);

   Optional<Content> findByIdAndUserId(String id,Long userId);

   List<Content> findByUserIdAndPartyIdContentLike(Long userId, Long partyId, String content);

   long countAllByUserIdAndPartyIdAndSearchString(String userId, String partyId, String searchString);

   List<Content> findAllByUserIdAndPartyIdLikeLimit5(Long userId, Long partyId);

   List<Content> findFirst5ByUserIdAndPartyIdAndContentLike(Long userId, Long partyId,String content);

   List<Content> findAllByUserIdAndPartyIdAndContentLike(Long userId, Long partyId,String content);

   Long countAllByUserIdAndPartyIdAndContentLike(Long userId, Long partyId, String searchString);

}
