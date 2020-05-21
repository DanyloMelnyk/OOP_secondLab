# Лабораторна робота №2 з ООП Мельника Данила
Лабораторна робота №2 з ООП студента групи КН115 Мельника Данила.

Використовується база даних MySQL8, налаштування в файлі **src/main/resources/application.properties**

Main class src/main/java/ua/lviv/ai/oop_labs/second/SecondOopLabApplication

При вникненні помилки при запуску 
> java.sql.SQLException: The server time zone value '' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the 'serverTimezone' configuration property) to use a more specifc time zone value if you want to utilize time zone support.

необхідно виконати команду 
```sql
SET @@global.time_zone = '+03:00';
```


------------

## /elements/

* #### GET
    Перегляд елементів в каталозі.
    Повертає масив елементів у JSON форматі.
    Якщо елементів немає повертає порожній масив.
    
    ##### Додаткові параметри:
    * float **maxPrice** - максимальна ціна елементів
    * String **producer** - виробник елементів
    * enum **sortBy** - критерій сортування (ID, NAME, VALUE, VOLTAGE, PRODUCER, TYPE, PRICE, AMOUNT; всі крім AMOUNT в порядку зростання, AMOUNT спадання)
    * enum **type** - тип елементів (список всіх типів `/elements/types`)

    ##### Приклад:
    * Запит: `GET http://localhost:8080/elements?maxPrice=1.5&producer=Hitano&sortBy=AMOUNT&type=RESISTOR&sortBy=TYPE`
    
        Body запиту: `none`
    
        Response status: `200 (OK)`
    
        Response body: 
        ```json
      [
          {
              "id": 40,
              "name": "Resistor 1 kOhm 5% 0.25W",
              "value": 1000.0,
              "voltage": 0.25,
              "producer": "Hitano",
              "type": "RESISTOR",
              "price": 0.4,
              "amount": 130000,
              "kits": [],
              "links": [
                  {
                      "rel": "self",
                      "href": "http://localhost:8080/elements/40"
                  },
                  {
                      "rel": "replacementForElement",
                      "href": "http://localhost:8080/elements/40/comp?sortBy=AMOUNT"
                  }
              ]
          },
          {
              "id": 31,
              "name": "Resistor 82 Ohm 5% 0.25W",
              "value": 82.0,
              "voltage": 0.25,
              "producer": "Hitano",
              "type": "RESISTOR",
              "price": 0.4,
              "amount": 12273,
              "kits": [],
              "links": [
                  {
                      "rel": "self",
                      "href": "http://localhost:8080/elements/31"
                  },
                  {
                      "rel": "replacementForElement",
                      "href": "http://localhost:8080/elements/31/comp?sortBy=AMOUNT"
                  }
              ]
          },
          {
              "id": 32,
              "name": "Resistor 10 Ohm 5% 0.25W",
              "value": 10.0,
              "voltage": 0.25,
              "producer": "Hitano",
              "type": "RESISTOR",
              "price": 0.4,
              "amount": 10000,
              "kits": [],
              "links": [
                  {
                      "rel": "self",
                      "href": "http://localhost:8080/elements/32"
                  },
                  {
                      "rel": "replacementForElement",
                      "href": "http://localhost:8080/elements/32/comp?sortBy=AMOUNT"
                  }
              ]
          }
      ]
      ```

* #### GET /{id}
    Поверає елемент з заданим id у JSON форматі. Якщо такого немає повертає код `404 (Not found)`.
    
    ##### Приклад:
    * Запит: `GET http://localhost:8080/elements/321`
    
        Body запиту: `none`
        
        Response status: `404 (Not found)`
        
        Response body: `none` <br><br>
        
    * Запит: `GET http://localhost:8080/elements/3`
          
         Body запиту: `none`
          
         Response status: `200 (OK)`
         
         Response body: 
         
         ```json
        {
            "id": 3,
            "name": "Glass fuse 4x11 100mA 250V",
            "value": 0.1,
            "voltage": 250.0,
            "producer": "Hollyland",
            "type": "FUSE",
            "price": 5.0,
            "amount": 645,
            "kits": [
                {
                    "id": 20,
                    "name": "testKitName2",
                    "producer": "DFROBOT",
                    "price": 129.99,
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/kits/20"
                        }
                    }
                },
                {
                    "id": 17,
                    "name": "testKitName1",
                    "producer": "DAGU",
                    "price": 84.99,
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/kits/17"
                        }
                    }
                }
            ],
            "_links": {
                "self": {
                    "href": "http://localhost:8080/elements/3"
                },
                "replacementForElement": {
                    "href": "http://localhost:8080/elements/3/comp?sortBy=ID"
                }
            }
        }
        ```

* #### GET /{id}/comp
    Повертає елементи-замінники елемента {id} у вигляді JSON-масиву.
    Якщо елемент {id} не існує повертає код `404 (Not found)`. Якщо не існує замінників повертає порожній масив.
    
    ##### Додаткові параметри:
    * enum **sortBy** - критерій сортування (ID, NAME, VALUE, VOLTAGE, PRODUCER, TYPE, PRICE, AMOUNT; всі крім AMOUNT в порядку зростання, AMOUNT спадання)
    
    ##### Приклад:
    * Запит: `GET http://localhost:8080/elements/321/comp`
        
        Body запиту: `none`
            
        Response status: `404 (Not found)`
            
        Response body: `none` <br><br>
            
    * Запит: `GET http://localhost:8080/elements/5/comp`
              
        Body запиту: `none`
              
        Response status: `200 (OK)`
           
        Response body: 
             
        ```json
        []
         ```


* #### POST
    Додавання до каталогу нового елемента, з body запиту. Параметр id елемента в body ігнорується, повертає елемент з створеним/оновленим полем id, доданим полем _links з посиланнями на сам елемент і його замінники.
    Якщо в списку kits є неіснуюючі набори вони будуть створені і до них буде доданий елемент; якщо існуюючі просто буде додано елемент. 

    ##### Приклад:
    * Запит: `POST http://localhost:8080/elements/`
            
        Body запиту:
        ```json
        {
            "name": "Capacitor 2,2 uF 16V",
            "value": 0.0022,
            "voltage": 16.0,
            "producer": "Hitano",
            "type": "CONDENSER",
            "price": 2.0,
            "amount": 10652,
            "kits": [
                {
                    "name": "testKitName9",
                    "producer": "Coolbass",
                    "price": 180.0
                }
            ]
        }
      ```                
        Response status: `201 (Created)`
                
        Response body:
      ```json
      {
            "id": 69,
            "name": "Capacitor 2,2 uF 16V",
            "value": 0.0022,
            "voltage": 16.0,
            "producer": "Hitano",
            "type": "CONDENSER",
            "price": 2.0,
            "amount": 10652,
            "kits": [
                {
                    "id": 70,
                    "name": "testKitName9",
                    "producer": "Coolbass",
                    "price": 180.0,
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/kits/70"
                        }
                    }
                }
            ],
            "_links": {
                "self": {
                    "href": "http://localhost:8080/elements/69"
                },
                "replacementForElement": {
                    "href": "http://localhost:8080/elements/69/comp?sortBy=ID"
                }
            }
      }
      ```
      <br>
    
    * Запит: `POST http://localhost:8080/elements/`
            
        Body запиту:
        ```json
        {
            "name": "Capacitor 4,7 uF 16V",
            "value": 0.0047,
            "voltage": 16,
            "producer": "Hitano",
            "type": "CONDENSER",
            "price": 2.2,
            "amount": 1652,
            "kits": [
                {
                    "id": 70,
                    "name": "testKitName9",
                    "producer": "Coolbass",
                    "price": 180
                }
            ]
        }
      ```                
        Response status: `201 (Created)`
                
        Response body:
      ```json
      {
          "id": 71,
          "name": "Capacitor 4,7 uF 16V",
          "value": 0.0047,
          "voltage": 16.0,
          "producer": "Hitano",
          "type": "CONDENSER",
          "price": 2.2,
          "amount": 1652,
          "kits": [
              {
                  "id": 70,
                  "name": "testKitName9",
                  "producer": "Coolbass",
                  "price": 180.0,
                  "_links": {
                      "self": {
                          "href": "http://localhost:8080/kits/70"
                      }
                  }
              }
          ],
          "_links": {
              "self": {
                  "href": "http://localhost:8080/elements/71"
              },
              "replacementForElement": {
                  "href": "http://localhost:8080/elements/71/comp?sortBy=ID"
              }
          }
      }
      ```    

* #### PUT /{id}
    Зміна елемента {id} на елемент з body запиту. Id елемента з body ігнорується. Якщо елемент {id} не існує повертає код `404 (Not found)`.

    ##### Приклад:
    * Запит: `PUT http://localhost:8080/elements/16`
        
        Body запиту:
        ```json
        {
            "id": 14,
            "name": "Capacitor 100 uF 10V",
            "value": 0.0001,
            "voltage": 10,
            "producer": "Rubycon",
            "type": "CONDENSER",
            "price": 0.75,
            "amount": 149
        }
        ```
            
        Response status: `200 (OK)`
            
        Response body: `none` <br><br>
            
    * Запит: `GET http://localhost:8080/elements/2122`
    
        Body запиту:
         ```json
        {
            "id": 14,
            "name": "Capacitor 100 uF 10V",
            "value": 0.0001,
            "voltage": 10,
            "producer": "Rubycon",
            "type": "CONDENSER",
            "price": 0.75,
            "amount": 149
        }
         ```          
              
        Response status: `404 (Not found)`
           
        Response body: `none`

* #### DELETE /{id}
    Видалення елемента {id}. Якщо елемент {id} не існує повертає код `404 (Not found)`.

    ##### Приклад:
    * Запит: `DELETE http://localhost:8080/elements/4`
        
        Body запиту: `none`
            
        Response status: `200 (OK)`
            
        Response body: `none` <br><br>
            
    * Запит: `DELETE http://localhost:8080/elements/2122`
    
        Body запиту: `none`
              
        Response status: `404 (Not found)`
           
        Response body: `none`

------------


JDK 14

java --enable-preview -jar second-0.0.1-SNAPSHOT.jar
