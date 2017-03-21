package com.gmail.yevgen.model;

import java.util.List;


public class Companies {
    public List<Company> items;
    public String publicationDate;

    public List<Company> getItems() {
        return items;
    }

    public void setItems(List<Company> items) {
        this.items = items;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }
}