Hangry is a mobile application that aims to streamline the dining experience at restaurants by
allowing users to browse menus, place orders, and make payments directly from their phones. The
app is designed to be used in a restaurant setting, where users can scan a QR code at their table to
access the menu and place an order. This eliminates the need for waitstaff and allows restaurants
to save money on labour costs while providing a more convenient and efficient service for
customers.
To use the Hangry app, a user simply needs to open the app and scan the QR code at their table
using their phone's camera. Once the QR code is scanned, the app will display the menu for the
specific restaurant and table the user is seated at. The user can then browse the menu and select
items to add to their cart. The app also allows users to view their order history, track the status of
their current order, and make changes to their order if needed.
Once the user has selected their items and is ready to checkout, they can enter their payment
information and place their order. The order is then transmitted to the restaurant's kitchen, where
it is prepared and served to the customer. The app also includes a messaging feature that allows
users to communicate with the restaurant staff if they have any special requests or dietary
restrictions.
In addition to providing a convenient and efficient dining experience for customers, the Hangry
app also offers benefits for restaurants. By eliminating the need for waitstaff, restaurants can save
money on labour costs and streamline their operations. The app also allows restaurants to track
orders and manage their inventory more effectively, as well as communicate with customers and
gather feedback.
Overall, the Hangry app is a versatile and user-friendly solution for enhancing the dining
experience at restaurants. It provides a convenient and efficient way for customers to browse
menus, place orders, and make payments, while also offering benefits for restaurants in terms of
cost savings and operational efficiency.

## API Reference

#### Get all items

```http
  GET /user
```

| Parameter | Type     | Description                    |
| :-------- | :------- | :-------------------------     |
| `{username}` | `object` | all user info |

#### Get item

```http
  POST /user/verify
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `{username,password}`      | `object` | true or false |

```http
  GET /hoteluser
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `null`      | `object` | all hotel owner info |

```http
  POST /hoteluser
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `{hotelName,foodItems}`      | `object` | saves the hotel owner details |


```http
  POST /hoteluser/verify
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `{hotelName,password}`      | `object` | returns true or false |


```http
  POST /food/:hotelname
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `{hotelName}`      | `object` | returns food items of a particular hotel |


```http
  POST /order
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `{hotelName}`      | `object` | returns fooditems ordered for a particular hotel |





## Appendix

Concept and Idea inspired by businesses like Zomato and Swiggy.


## Authors

- [@Tushar-Karkera](https://www.github.com/Tushar-karkera)




## Color Reference

| Color             | Hex                                                                |
| ----------------- | ------------------------------------------------------------------ |
| Orange | ![#d17c21](https://via.placeholder.com/10/d17c21?text=+) #d17c21 |
| White | ![#f8f8f8](https://via.placeholder.com/10/f8f8f8?text=+) #f8f8f8 |
| Grey | ![#57524c](https://via.placeholder.com/10/57524c?text=+) #00b48a |
| Green | ![#00d1a0](https://via.placeholder.com/10/00b48a?text=+) #00d1a0 |


## Contributing

Contributions are always welcome!

Get in touch to contribute.

Please adhere to this project's `code of conduct`.

