package com.developpeurgirondin.kitschmusic.repository.search;

import com.developpeurgirondin.kitschmusic.domain.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the User entity.
 */
public interface UserSearchRepository extends ElasticsearchRepository<User, Long> {}
