
package com.gustavo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.gustavo.entities.Post;

public interface PostRepository extends MongoRepository<Post, String>{

}
