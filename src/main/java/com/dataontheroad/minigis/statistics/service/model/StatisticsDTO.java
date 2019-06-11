package com.dataontheroad.minigis.statistics.service.model;

public class StatisticsDTO {

    private int countries;
    private int items;
    private int users;

    public StatisticsDTO(int countries, int items, int users) {
        this.countries = countries;
        this.items = items;
        this.users = users;
    }

    public int getCountries() {
        return countries;
    }

    public int getItems() {
        return items;
    }

    public int getUsers() {
        return users;
    }
}
