package com.url.app.urllinkShort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.url.app.urllinkShort.model.Url;

public interface UrlRepository extends JpaRepository<Url, Integer> {
	
	@Query(value = "select originalurl from Url u where shorturl = ?1", nativeQuery = true)
	String findByShortUrl(String id);
	
}