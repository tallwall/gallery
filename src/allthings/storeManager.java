package allthings;

public class storeManager {
    private String first_name;
    private String last_name;
    private float wallet;
    private int inventory = 6 ;

    public storeManager(String first_name, String last_name, float wallet) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.wallet = wallet;
    }



    public void addImage (Image image) throws Exception{
        float cashLeft = this.wallet - image.getPrice();
        if (cashLeft < 0)
            throw new Exception();
        this.wallet = cashLeft;
        inventory++;
    }

    public int getInventory (){
        return this.inventory;
    }

    public void setBadPrice(Image image, float discount) {
        if (image.isBad()) {
            float price = image.getPrice();
            image.setPrice(price - discount);
        }
    }


}
