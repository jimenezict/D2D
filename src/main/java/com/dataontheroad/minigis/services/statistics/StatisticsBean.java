package com.dataontheroad.minigis.services.statistics;

public class StatisticsBean {

    private int countries;
    private int items;
    private int users;

    public StatisticsBean(int countries, int items, int users) {
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
