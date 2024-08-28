package com.example.githubapi.Controllers;

import com.example.githubapi.Models.GitHubUser;
import com.example.githubapi.Services.GitHubService;
import com.example.githubapi.Services.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class GitHubController {

    @Autowired
    private GitHubService gitHubService;

    @Autowired
    private RepositoryService repositoryService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(required = false) String username,
                         @RequestParam(required = false) String repositoryLink,
                         Model model) throws IOException {

        // Debugging: Linki kontrol et
        System.out.println("Repository Link: " + repositoryLink);

        if (username != null && !username.isEmpty() && repositoryLink != null && !repositoryLink.isEmpty()) {
            model.addAttribute("result", "Lütfen yalnızca bir arama kriteri girin.");
            return "index";
        }

        if (username != null && !username.isEmpty()) {
            GitHubUser gitHubUser = gitHubService.getUserInfo(username);
            model.addAttribute("result", gitHubUser != null ? gitHubUser.toString() : "Kullanıcı bulunamadı.");
        } else if (repositoryLink != null && !repositoryLink.isEmpty()) {
            String result = repositoryService.getTopContributorsByLink(repositoryLink);
            model.addAttribute("result", result);
        } else {
            model.addAttribute("result", "Lütfen bir arama kriteri girin.");
        }

        return "index";
    }
}
