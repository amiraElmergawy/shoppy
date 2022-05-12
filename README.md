# Shoppy

An e-commerce website that sells furnitures, built using Jakarta EE 9 technologies and layered architecture as our second project at the Information Technology Institute. 

# 📦 Features
- Registration and login
- Add product admin
- Edit product admin
- Delete product admin
- View all customers admin
- View order history admin
- View homepage customer
- View product details customer
- View shopping cart customer
- Add product to cart customer
- Increase & decrease product quantity from cart customer
- Save cart even if customer logged out
- View profile customer
- Edit profile customer
- Search for product by name customer
- Checkout using Stripe payment customer
- Logout customer and admin

# ⚙ Technologies used
- Maven
- Apache Tomcat 10.0.20
- Jakarta Persistence (Hibernate)
- MySQL
- Jakarta Server Pages
- Jakarta Servlet
- Jakarta Standard Tag Library
- HTML
- CSS
- JavaScript
- Bootstrap
- Ajax
- Lombok
- Gson
- mapstruct
- Stripe payment integration

# 🛠 Run with Maven
Clone the project

```bash
  git clone https://github.com/heshmAhmed/shoppy
```

Go to the project directory

```bash
  cd shoppy
```
- Create db user and set the username and password values in the persistence.xml
- Create db named shoppy in your MySql Server 
- Run your tomcat apache server and then change the configuration of tomcat in pom.xml
- Deploy the application using the following maven command
```
  mvn clean package tomcat7:deploy
```


# 👷‍♀️ Contributors

- [Hesham Ahmed](https://github.com/heshmAhmed)
- [Amira Elmergawy](https://github.com/amiraElmergawy)
- [Abdelaziz Eldahshan](https://github.com/abdelazizeldahshan)
- [Hala Tarek](https://github.com/Hala-45)
- [Sally Elbanawany](https://github.com/sallyElbanawany)
