package com.rest.webservice.webservices.dao;

import com.rest.webservice.webservices.beans.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
