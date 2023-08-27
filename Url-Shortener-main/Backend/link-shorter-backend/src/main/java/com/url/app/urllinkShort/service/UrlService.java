package com.url.app.urllinkShort.service;

import static com.url.app.urllinkShort.logic.GenerateShortUrl.getShortUrl;
import static com.url.app.urllinkShort.logic.GenerateShortUrl.isUrlValid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.url.app.urllinkShort.model.Url;
import com.url.app.urllinkShort.repository.UrlRepository;

@Service
public class UrlService {
	
	@Autowired
	private UrlRepository urlRepository;
	
	public String getOriginalUrl(String id) {
		return urlRepository.findByShortUrl(id);
	}
	
	public Url generateShortUrl(String url) {
		System.out.println(url);
		if (!isUrlValid(url)) {
			System.out.println("URL is not valid");
			return null;
		}
		
		Url urlObject = new Url();
		urlObject.setOriginalurl(url);
		urlObject.setShorturl(getShortUrl(url));
		return urlRepository.save(urlObject);
	}
}