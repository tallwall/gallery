package allthings;


import java.util.*;

public class insideGallery {
    public static ArrayList<Image> imagesArrayList = new ArrayList<>();


    public insideGallery() {
        Image lebronjames = new Image("Nike presents: Lebron James ", 79500, true, false, "300 by 600");
        imagesArrayList.add(lebronjames);
        Image paulgeorge = new Image("Nike presents: Playoff P ", 10000, true, false, "800 by 600");
        imagesArrayList.add(paulgeorge);
        Image chrispaul = new Image("Jordan presents: Chris Paul ", 45000, true, false, "1000 by 600");
        imagesArrayList.add(chrispaul);
        Image mosalah = new Image("The MO SALAH 11", 75000, true, false, "300 by 500");
        imagesArrayList.add(mosalah);
        Image liverpoolfc = new Image("English Premier League Champions: LiverPool FC ", 10500, false, false, "300 by 700");
        imagesArrayList.add(liverpoolfc);


        System.out.println("Welcome, Beinvenue!");
        System.out.println("This is Tolu's Gallery \n" +
                "You can be a consumer... \n " +
                "or the store Manager... ");

        // Random number gen to determine how much money the store manager has in order to start
        Random r = new Random();
        int low = 10000;
        int high = 100000;
        int result = r.nextInt(high - low) + low;
        // Random number gen to determine how much money the buyer has in order to start
        Random r2 = new Random();
        int low2 = 10000;
        int high2 = 100000;
        int result2 = r2.nextInt(high2 - low2) + low;


        Scanner sc = new Scanner(System.in);

        System.out.println("Are you the Consumer or Manager? Consumer = 1, Manager = 2 ");
        int choice1 = sc.nextInt();


        if (choice1 == 1) {
            System.out.println(" You are a consumer, you can sell or buy images at Tolu's gallery \n [1] to sell, [2] to buy ");
            int choice2 = sc.nextInt();
            System.out.println("Input your first_name");
            String first_name = sc.next();
            System.out.println("Input your last_name");
            String last_name = sc.next();
            System.out.println("Mr. " + last_name + " has " + result2 + " in his wallet.");
            Consumer consumer = new Consumer(first_name, last_name, result2);
            storeManager manager = new storeManager("", "", result);
            int invent = manager.getInventory();

            while (choice2 == 1 || choice2 == 2) {
                if (choice2 == 1) {
                    System.out.println("Input the name of your Image: ");
                    String nameImage = sc.next();
                    System.out.println("Input the price of your Image: ");
                    int price = sc.nextInt();
                    System.out.println("Is it framed? for yes type 'true', for no type 'false'");
                    boolean isframed = sc.nextBoolean();
                    System.out.println("Is it damaged? for yes type 'true', for no type 'false'");
                    boolean isbad = sc.nextBoolean();
                    System.out.println("Input the size of your Image: ");
                    String sizeofimage = sc.next();
                    Image image1 = new Image(nameImage, price, isframed, isbad, sizeofimage);
                    if (image1.isBad()) {
                        manager.setBadPrice(image1, 1000);
                        System.out.println("Manager will deduct 1000 for bad condition");
                        price = price - 1000;
                    }
                    try {
                        consumer.sellImage(image1);
                    } catch (Exception e) {
                        System.out.println("Manager cannot afford to purchase the image");
                    }
                    image1.setPrice(price);
                    imagesArrayList.add(image1);
                    for (Image image : imagesArrayList) {
                        System.out.println(image.getNameImage());
                    }
                    System.out.println("[1] to sell, [2] to buy ");
                    choice2 = sc.nextInt();
                } else if (choice2 == 2) {
                    System.out.println("Which image would you like to buy 1 to " + imagesArrayList.size());
                    for (Image image : imagesArrayList) {
                        System.out.println(image.getNameImage());
                    }
                    int index = sc.nextInt();


                    if (index > 0 && index <= imagesArrayList.size()) {
                        for (int i = 0; i < imagesArrayList.size(); i++) {
                            if (i == index - 1) {
                                System.out.println("Buying... " + index + " " + imagesArrayList.get(i).getNameImage() +
                                        " for " + imagesArrayList.get(i).getPrice());
                                invent--;
                                try {
                                    consumer.buyImage(imagesArrayList.get(i));
                                } catch (Exception e) {
                                    System.out.println("The buyer does not have enough money to purchase the painting, they have " + consumer.getWallet() );
                                }
                                imagesArrayList.remove(imagesArrayList.get(i));
                                if (imagesArrayList.isEmpty()) {
                                    System.exit(0);
                                }
                            }
                        }
                    } else {
                        System.out.println("Invalid Entry...Goodbye");
                    }
                    System.out.println("[1] to sell, [2] to buy ");
                    choice2 = sc.nextInt();
                }
            }


        } else if (choice1 == 2) {
            System.out.println("Input your first_name");
            String first_name = sc.next();
            System.out.println("Input your last_name");
            String last_name = sc.next();


            storeManager manager = new storeManager(first_name, last_name, result);
            System.out.println("Mr." + last_name + " is the store Manager \n" +
                    "you have this amount " + result + " in your wallet \n" +
                    "you can sell or check inventory at Tolu's gallery \n [1] to sell, [2] to check inventory ");

            int sellinv = sc.nextInt();
            int invent = manager.getInventory();
            while (sellinv == 1 || sellinv == 2) {
                if (sellinv == 1) {
                    System.out.println("Which image would you like to sell 1 to " + imagesArrayList.size());
                    for (Image image : imagesArrayList) {
                        System.out.println(image.getNameImage());
                    }
                    int index = sc.nextInt();
                    if (index > 0 && index <= imagesArrayList.size()) {
                        for (int i = 0; i < imagesArrayList.size(); i++) {
                            if (i == index - 1) {
                                System.out.println("You are selling " + index + " " + imagesArrayList.get(i).getNameImage() +
                                        " for " + imagesArrayList.get(i).getPrice());
                                result = result + Math.round(imagesArrayList.get(i).getPrice());
                                invent = invent - 1;
                                imagesArrayList.remove(i);
                                if (imagesArrayList.isEmpty()) {
                                    System.exit(0);
                                }
                            }
                        }
                    } else {
                        System.out.println("Invalid Entry...Goodbye");
                    }
                    System.out.println("[1] to sell, [2] to check inventory");
                    sellinv = sc.nextInt();
                } else if (sellinv == 2) {
                    System.out.println(invent + " images in stock and you have " + result);
                    System.out.println("[1] to sell, [2] to check inventory");
                    sellinv = sc.nextInt();
                } else {
                    System.out.println("Invalid Entry...Goodbye");
                    System.exit(4);
                }
            }


        } else if (choice1 != 1 || choice1 != 2) {
            System.out.println("Gets here");
            System.exit(5);
        }


    }
}
