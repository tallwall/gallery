# Gallery Repo

Access a Image Gallery as a Owner or Consumer, coded using the java language.

## Installation

Open on any java console and click "Run"! Prompts and instructions are embedded in code.

## Usage

```java
import allthings;

consumer.buyImage(Image image, Wallet wallet) # buys image with given parameters, adjust cash left in wallet positively
consumer.sellImage(Image image, Wallet wallet) # sells image with given parameters, adjust cash left in wallet positively
manager.sellImage(Image image, Wallet wallet) # sells image with given parameters, adjust cash left in wallet positively
manager.getInventory(int Inventory) # returns inventory
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## Possible Future features
- Password protect owner
- Allow consumer to buy/sell more than one image at a time.
- Allow manager to sell/buy more than one image at a time.
- Allow consumer to search for certain imaages
- Increase number of images