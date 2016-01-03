# tf2-prices-java
A Java API for getting TF2 Item prices from [TF2](http://www.teamfortress.com) website, [backpack.tf](http://www.backpack.tf).

#API Use Requirements
- JSoup Jar Version 1.8.3, which can be downloaded [here](http://jsoup.org/packages/jsoup-1.8.3.jar).
- For the tests, JUNIT 4 (Add it in using your IDE)

#General Setup

1. Download the src/api folder and add it to your next java project.
2. Download the JSOUP Jar from [here](http://jsoup.org/packages/jsoup-1.8.3.jar).

#Getting Started with the API

This API is based off using ItemFetcher to get a new immutable Item object, from which information can be extracted.  **Here is how to get a start with the api**.  The constructor for the ItemFetcher will be discuessed further in the documentation.

```
Item myTF2item = new ItemFetcher("URL-EXTENSION").getItem();
```

Boom!.  You just created your first Item object using this backpack.tf API.  **You may ask, "What is my 'URL-EXTENSION'?"** Well, this next section covers it.

#Constructing an ItemFetcher object

First, let's take a look at a generic backpack.tf URL for an item.  This `backpack.tf/stats/Collector%27s/Conniver%27s%20Kunai/Tradable/Craftable` is the URL for a Collector's Conniver's Kunai, that is tradable and craftable.  For the API, this entire link isn't required.  The only part of the URL required in the constructor is the part after `.tf`.  So in this example, `/stats/Collector%27s/Conniver%27s%20Kunai/Tradable/Craftable` is all that would be passed to `ItemFetcher`.  So the constructor for the item based on this URL would be `Item myTF2item = new ItemFetcher("/stats/Collector%27s/Conniver%27s%20Kunai/Tradable/Craftable").getItem();`  Support for construction based off of the name and qualities is a feature that will hopefully be implemented in the future.

#Available Item Information (Methods Available)

```
getName(); //Get the name
getQuality(); //Get the quality (Strange, Unique, Unusual, etc.)
getRefPrice(); //Get the price in refined metal
getKeyPrice(); //Get the price in Regular Supply Crate Keys
getDollarPrice(); //Get the price in USD
```

#Future Hopes (TODO)
- A function that gets the value in a requested currency.  For example, `getCurrencyPrice("GBP")`
- A function that finds the liquidity value for an item (How often is this item changing hands in the economy?  How many trades with this item are happening?) 
- A function that returns the volatility of an item 
- The ability to get full backpacks






