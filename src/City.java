public class City {
    private String cityName;
    private String geographicDistrict;
    private String streetsList;

    public City(String cityName,String geographicDistrict,String streetsList){
        this.cityName = cityName;
        this.geographicDistrict = geographicDistrict;
        this.streetsList = streetsList;
    }
    public City(){}

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
    public String getStreetsList() {
        return this.streetsList;
    }
    public void setCityName(String cityName){
        this.cityName = cityName;
    }
    public void setGeographicDistrict(String geographicDistrict){
      this.geographicDistrict = geographicDistrict;
    }
    public void setStreetsList(String streetsList){
       this.streetsList = streetsList;
    }
}

