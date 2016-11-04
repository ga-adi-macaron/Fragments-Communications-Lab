---
title: Grocery List with Details and Fragments
type: lab
duration: "1:25"
creator:
    name: Drew Mahrt
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) Grocery List with Details and Fragments

## Introduction

> ***Note:*** _This can be a pair programming activity or done independently._

In this lab, we will be transforming our Grocery List with details to use Fragments instead of multiple activities. The main fragment should contain the shopping list in a RecyclerView, and when the user clicks on one of the grocery items, your app will navigate to a detail fragment that will display extra details about the item. The details you need to display are already stored in the columns for `description`, `price`, and `type`. This version of the app should be identical in terms of the information being displayed, the only difference is that navigation is now handled by fragments instead of activities.

<p align="center">
  <img src="./screenshots/database.png" width="60%">
</p>

## Exercise

#### Requirements

- Allow the user to click on a grocery item to go to a detail **fragment**
- Display all four details from the database
- Gather the details for the selected item from the database (not passed through the intent)

**Bonus:**
- Add additional columns to the database and display those on the details fragment

#### Starter code

The [starter code](starter-code) contains the the solution code to the Detail View lab. If your code from that lab was working properly, you may continue using that codebase instead, if you prefer.

#### Deliverable

Here are screenshots of what the master and detail views should look like:

<p align="center">
  <img src="screenshots/screen1.png" width="300">
  <img src="screenshots/screen2.png" width="300">
</p>

## Additional Resources

- [Activities and Intents](http://developer.android.com/guide/components/intents-filters.html)
- [SQLite Database Documentation](http://developer.android.com/reference/android/database/sqlite/SQLiteDatabase.html)

---

## Licensing
1. All content is licensed under a CC­BY­NC­SA 4.0 license.
2. All software code is licensed under GNU GPLv3. For commercial use or alternative licensing, please contact [legal@ga.co](mailto:legal@ga.co).
