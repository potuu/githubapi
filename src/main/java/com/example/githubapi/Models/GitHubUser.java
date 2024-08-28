package com.example.githubapi.Models;

public class GitHubUser {
    private String login;
    private String name;
    private String company;
    private String location;
    private int public_repos;
    private int followers;
    private int following;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(int public_repos) {
        this.public_repos = public_repos;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    @Override
    public String toString(){
        return "Username: "+login+"\n"+
                "Name: "+name+"\n"+
                "Company: "+company+"\n"+
                "Location: "+location+"\n"+
                "Public Repositories: "+public_repos+"\n"+
                "Followers: "+followers+"\n"+
                "Following: "+following;
    }


}
