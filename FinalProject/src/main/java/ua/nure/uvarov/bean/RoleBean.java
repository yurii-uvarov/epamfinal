package ua.nure.uvarov.bean;

import java.util.Set;

public class RoleBean implements Bean {
    private String name;
    private Set<String> urls;

    public RoleBean(String name, Set<String> urls) {
        this.name = name;
        this.urls = urls;
    }

    public void addUrl(String url){
        urls.add(url);
    }
}
