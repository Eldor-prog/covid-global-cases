package uz.eldor.trackcovid2.ui.country;

public class CovidCountry {
    private String continent;
    private String country;
    private double recoveredPerOneMillion;
    private int cases;
    private int critical;
    private int oneCasePerPeople;
    private int active;
    private int testsPerOneMillion;
    private int population;
    private int oneDeathPerPeople;
    private int recovered;
    private int oneTestPerPeople;
    private int tests;
    private double criticalPerOneMillion;
    private int deathsPerOneMillion;
    private int todayRecovered;
    private int casesPerOneMillion;
    private CountryInfo countryInfo;
    private long updated;
    private int deaths;
    private double activePerOneMillion;
    private int todayCases;
    private int todayDeaths;

    public CovidCountry(String country, int cases) {
        this.continent = continent;
        this.country = country;
        this.recoveredPerOneMillion = recoveredPerOneMillion;
        this.cases = cases;
        this.critical = critical;
        this.oneCasePerPeople = oneCasePerPeople;
        this.active = active;
        this.testsPerOneMillion = testsPerOneMillion;
        this.population = population;
        this.oneDeathPerPeople = oneDeathPerPeople;
        this.recovered = recovered;
        this.oneTestPerPeople = oneTestPerPeople;
        this.tests = tests;
        this.criticalPerOneMillion = criticalPerOneMillion;
        this.deathsPerOneMillion = deathsPerOneMillion;
        this.todayRecovered = todayRecovered;
        this.casesPerOneMillion = casesPerOneMillion;
        this.countryInfo = countryInfo;
        this.updated = updated;
        this.deaths = deaths;
        this.activePerOneMillion = activePerOneMillion;
        this.todayCases = todayCases;
        this.todayDeaths = todayDeaths;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCases(int cases) {
        this.cases = cases;
    }

    public String getCountry() {
        return country;
    }

    public int getCases() {
        return cases;
    }
}
