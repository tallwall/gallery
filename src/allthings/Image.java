package allthings;

public class Image {
    private String nameImage;
    private float price;


    private boolean isBad;
    private boolean isFramed;

    private String sizeofImage;




    public Image(String nameImage, float price, boolean isFramed, boolean isBad, String sizeofImage ) {
        this.nameImage = nameImage;
        this.price = price;
        this.isBad = isFramed;
        this.isBad = isBad;
        this.sizeofImage = sizeofImage;
    }




    public String getNameImage(){
        return nameImage;
    }
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isBad() {
        return isBad;
    }

    public boolean isFramed() {
        return isFramed;
    }

}
