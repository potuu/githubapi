package com.example.githubapi.Services;

import com.example.githubapi.Models.GitHubUser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubServiceImpl implements GitHubService {
    private final String GITHUB_API_URL = "https://api.github.com/users/";
    private final RestTemplate restTemplate;

    public GitHubServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public GitHubUser getUserInfo(String username) {
        return restTemplate.getForObject(GITHUB_API_URL + username, GitHubUser.class);
    }
}
