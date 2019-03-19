package org.pursuit.viewpager_json;

import java.util.List;

public  class PlanetsWrapper {

    private List<Planets> planets;

    public PlanetsWrapper(List<Planets> planets) {
        this.planets = planets;
    }

    public List<Planets> getPlanets() {
        return planets;
    }


}
