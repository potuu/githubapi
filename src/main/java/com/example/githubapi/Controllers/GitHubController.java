package com.example.githubapi.Controllers;


import com.example.githubapi.Models.GitHubUser;
import com.example.githubapi.Services.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GitHubController {
    @Autowired
    private GitHubService gitHubService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/getUserInfo")
    public String getUserInfo(@RequestParam("username") String username, Model model) {
        if (username.equalsIgnoreCase("quit") || username.equalsIgnoreCase("exit")) {
            System.exit(0); // Uygulamadan çıkış
        }

        GitHubUser gitHubUser=gitHubService.getUserInfo(username);
        model.addAttribute("user",gitHubUser);
        return "index";

    }
}
