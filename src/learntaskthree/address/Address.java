package learntaskthree.address;

import java.util.StringTokenizer;

public class Address {
    private String country, region, city, house, flat;

    //Реализация, когда разделитель ,
    public void setAddrComma(String address){
        String[] splited = address.split(",");
        country = splited[0].trim();
        region = splited[1].trim();
        city = splited[2].trim();
        house = splited[3].trim();
        flat = splited[4].trim();
    }

    //Реализация через StringTokenizer, когда разделители ,;-.
    public void setAddrToken(String address){
        StringTokenizer st = new StringTokenizer(address, ",;-.");

        country = st.nextToken().trim();
        region = st.nextToken().trim();
        city = st.nextToken().trim();
        house = st.nextToken().trim();
        flat = st.nextToken().trim();
    }

    //возвращает полный адрес
    public String getFullAddress(){
        return "Country: " + country + " Region: " + region + " City: " + city + " House: " + house + " Flat: " + flat;
    }
}
