public class City {
    private String cityName;
    private String geographicDistrict;
    private String streetsList;

    public String toString(){
        String cityContent;
        cityContent= "The name of the city" + this.cityName
                + "The geographic district" + this.geographicDistrict+
                "The name of the streets" + streetsList;
        return cityContent;
    }
    public String getCityName() {
        return this.cityName;
    }
}
