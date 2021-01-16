package allthings;

import allthings.Image;

public class Consumer {
    private String first_name;
    private String last_name;
    private float wallet;

    public Consumer(String first_name, String last_name, float wallet) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.wallet = wallet;
    }

   public void buyImage (Image image) throws Exception {
        float cashLeft = this.wallet - image.getPrice();
        if (cashLeft < 0) {
            throw new Exception();
        }
        this. wallet = cashLeft;
    }
    public void sellImage (Image image) throws Exception {
        float cashLeft = this.wallet + image.getPrice();
        if (cashLeft < 0) {
            throw new Exception();
        }
        this. wallet = cashLeft;
    }
    public float getWallet(){
        return wallet;
    }

}
