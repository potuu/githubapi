package com.example.githubapi.Services;

import com.example.githubapi.Models.GitHubUser;

public interface GitHubService {
    GitHubUser getUserInfo(String username);
}
