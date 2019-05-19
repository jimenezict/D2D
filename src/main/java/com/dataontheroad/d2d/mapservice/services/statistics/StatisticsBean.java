package com.dataontheroad.d2d.mapservice.services.statistics;

public class StatisticsBean {

    private int countries;
    private int fountains;
    private int users;

    public StatisticsBean(int countries, int fountains, int users) {
        this.countries = countries;
        this.fountains = fountains;
        this.users = users;
    }

    public int getCountries() {
        return countries;
    }

    public int getFountains() {
        return fountains;
    }

    public int getUsers() {
        return users;
    }
}
