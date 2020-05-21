# Лабораторна робота №2 з ООП Мельника Данила
Лабораторна робота №2 з ООП студента групи КН115 Мельника Данила.

Необхідний [**JDK 14**](https://www.oracle.com/java/technologies/javase-jdk14-downloads.html)
           
Команда для запуску скомпільованої програми `java --enable-preview -jar second-0.0.1-SNAPSHOT.jar`. 

Main class _**src/main/java/ua/lviv/ai/oop_labs/second/SecondOopLabApplication.java**_

Використовується база даних **MySQL8**, налаштування в файлі _**src/main/resources/application.properties**_

Дамп тестової бази даних з тестовими даними знаходиться в файлі **_Database.sql_**

Файл "**_OOP second lab.postman_collection.json_**" - тестові запити експортовані з Postman.

Архів **_INTELLIJ_IDEA.zip_** - експортований з IntelliJ IDEA проект.

<br>

При вникненні помилки при запуску 
> java.sql.SQLException: The server time zone value '' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the 'serverTimezone' configuration property) to use a more specifc time zone value if you want to utilize time zone support.

в MySQL Workbench необхідно виконати команду 
```sql
SET @@global.time_zone = '+03:00';
```
<br>

[GitHub](https://github.com/DanyloMelnyk/OOP_secondLab)
[Telegram](http://t.me/mel2danylo)

------------

## Приклад даних у JSON форматі
### Element 
```json
{
    "id": 6,
    "name": "Resistor 3,6 Ohm 5% 0.125W",
    "value": 3.6,
    "voltage": 0.125,
    "producer": "Uni Ohm",
    "type": "RESISTOR",
    "price": 0.3,
    "amount": 21227,
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
        }
    ],
    "_links": {
        "self": {
            "href": "http://localhost:8080/elements/6"
        },
        "replacementForElement": {
            "href": "http://localhost:8080/elements/6/comp?sortBy=ID"
        }
    }
}
   ```

### Kit
```json
{
    "id": 17,
    "name": "testKitName1",
    "producer": "DAGU",
    "price": 84.99,
    "elements": [
        {
            "id": 3,
            "name": "Glass fuse 4x11 100mA 250V",
            "value": 0.1,
            "voltage": 250.0,
            "producer": "Hollyland",
            "type": "FUSE",
            "price": 5.0,
            "amount": 645,
            "_links": {
                "self": {
                    "href": "http://localhost:8080/elements/3"
                },
                "replacementForElement": {
                    "href": "http://localhost:8080/elements/3/comp?sortBy=ID"
                }
            }
        }
    ],
    "_links": {
        "self": {
            "href": "http://localhost:8080/kits/17"
        }
    }
}
  ```

------------

## Доступні запити
* [/elements/](https://github.com/DanyloMelnyk/OOP_secondLab#elements)
    * **GET** /elements/
    * **GET** /elements/{id}
        * **GET** /elements/{id}/comp
    * **POST** /elements/
    * **PUT** /elements/{id}
    * **DELETE** /elements/{id}
    * **GET** /elements/types
    * **GET** /elements/sortMethods <br><br>
* [/kits/](https://github.com/DanyloMelnyk/OOP_secondLab#kits)
    * **GET** /kits/
    * **GET** /kits/{id}
    * **POST** /kits/
    * **PUT** /kits/{id}
    * **DELETE** /kits/{id}
    * **GET** /kits/sortMethods
        
------------

## /elements/

* #### GET
    Перегляд елементів в каталозі.
    Повертає масив елементів у JSON форматі.
    Якщо елементів немає повертає порожній масив.
    
    ##### Додаткові параметри:
    * float **maxPrice** - максимальна ціна елементів
    * String **producer** - виробник елементів
    * enum **sortBy** - критерій сортування (список всіх критеріїв `/elements/sortMethods`; всі крім AMOUNT в порядку зростання, AMOUNT - спадання)
    * enum **type** - тип елементів (список всіх типів `/elements/types`)

    ##### Приклад:
    * Запит: `GET http://localhost:8080/elements?maxPrice=1.5&producer=Hitano&sortBy=AMOUNT&type=RESISTOR`
    
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
    * enum **sortBy** - критерій сортування (список всіх критеріїв `/elements/sortMethods`; всі крім AMOUNT в порядку зростання, AMOUNT - спадання)
    
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
            
    * Запит: `PUT http://localhost:8080/elements/2122`
    
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
        
* #### GET /types
    Повертає масив всіх типів елементів.

    ##### Приклад:
    * Запит: `GET http://localhost:8080/elements/types`
    
        Body запиту: `none`
    
        Response status: `200 (OK)`
    
        Response body: 
        ```json
      [
          "IC",
          "TRANSISTOR",
          "DIODE",
          "LED",
          "CONDENSER",
          "RESISTOR",
          "FUSE",
          "QUARTZ_RESONATOR"
      ]
      ```        
        
* #### GET /sortMethods
    Повертає масив всіх критеріїв сортування елементів.

    ##### Приклад:
    * Запит: `GET http://localhost:8080/elements/sortMethods`
    
        Body запиту: `none`
    
        Response status: `200 (OK)`
    
        Response body: 
        ```json
      [
          "ID",
          "NAME",
          "VALUE",
          "VOLTAGE",
          "PRODUCER",
          "TYPE",
          "PRICE",
          "AMOUNT"
      ]
      ```          
        
------------

## /kits/

* #### GET
    Перегляд наборів елементів в каталозі.
    Повертає масив наборів у JSON форматі.
    Якщо наборів немає повертає порожній масив.
    
    ##### Додаткові параметри:
    * float **maxPrice** - максимальна ціна елементів
    * String **producer** - виробник елементів
    * enum **sortBy** - критерій сортування (список всіх критеріїв `/elements/sortMethods`; всі крім AMOUNT в порядку зростання, AMOUNT - спадання)

    ##### Приклад:
    * Запит: `GET http://localhost:8080/kits?sortBy=PRODUCER&maxPrice=100.0&producer=DAGU`
        Body запиту: `none`
    
        Response status: `200 (OK)`
    
        Response body: 
        ```json
      [
          {
              "id": 17,
              "name": "testKitName1",
              "producer": "DAGU",
              "price": 84.99,
              "elements": [
                  {
                      "id": 3,
                      "name": "Glass fuse 4x11 100mA 250V",
                      "value": 0.1,
                      "voltage": 250.0,
                      "producer": "Hollyland",
                      "type": "FUSE",
                      "price": 5.0,
                      "amount": 645,
                      "links": [
                          {
                              "rel": "self",
                              "href": "http://localhost:8080/elements/3"
                          },
                          {
                              "rel": "replacementForElement",
                              "href": "http://localhost:8080/elements/3/comp?sortBy=ID"
                          }
                      ]
                  }
              ],
              "links": [
                  {
                      "rel": "self",
                      "href": "http://localhost:8080/kits/17"
                  }
              ]
          }
      ]
      ```

* #### GET /{id}
    Поверає набір з заданим id у JSON форматі. Якщо такого немає повертає код `404 (Not found)`.
    
    ##### Приклад:
    * Запит: `GET http://localhost:8080/kits/22233`
    
        Body запиту: `none`
        
        Response status: `404 (Not found)`
        
        Response body: `none` <br><br>
        
    * Запит: `GET http://localhost:8080/kits/17`
          
         Body запиту: `none`
          
         Response status: `200 (OK)`
         
         Response body: 
         
         ```json
        {
            "id": 17,
            "name": "testKitName1",
            "producer": "DAGU",
            "price": 84.99,
            "elements": [
                {
                    "id": 3,
                    "name": "Glass fuse 4x11 100mA 250V",
                    "value": 0.1,
                    "voltage": 250.0,
                    "producer": "Hollyland",
                    "type": "FUSE",
                    "price": 5.0,
                    "amount": 645,
                    "_links": {
                        "self": {
                            "href": "http://localhost:8080/elements/3"
                        },
                        "replacementForElement": {
                            "href": "http://localhost:8080/elements/3/comp?sortBy=ID"
                        }
                    }
                }
            ],
            "_links": {
                "self": {
                    "href": "http://localhost:8080/kits/17"
                }
            }
        }
        ```

* #### POST
    Додавання до каталогу нового набору, з body запиту. Параметр id набору в body ігнорується, повертає набір з створеним/оновленим полем id, доданим полем _links з посиланням на сам набір.
    Якщо в списку elements є неіснуюючі елементи (з неіснуючим id) вони будуть створені і додані в набір; якщо існуюючі просто будть додані в набір(при цьому можна вказувати лише id елемента, інші його дані ігноруються).
    Якщо елементи існували до надслання запиту то їхні поля (окрім _links) у відповіді будуть = null.

    ##### Приклад:
    * Запит: `POST http://localhost:8080/kits/`
            
        Body запиту:
        ```json
        {
            "name": "testKitName10",
            "producer": "Sparkfun",
            "price": 700.99,
            "elements": [
                {
                    "id": 65
                },
                {
                    "id": 40
                },
                {
                    "id": 26
                },
                {
                    "id": 22
                },
                {
                	"id": 129,
                    "name": "Capacitor 470 nF 100V",
                    "value": 0.00000047,
                    "voltage": 100,
                    "producer": "Epcos",
                    "type": "CONDENSER",
                    "price": 1.3,
                    "amount": 8025
                }
            ]
        }
      ```                
        Response status: `201 (Created)`
                
        Response body:
      ```json
      {
          "id": 77,
          "name": "testKitName10",
          "producer": "Sparkfun",
          "price": 700.99,
          "elements": [
              {
                  "id": 26,
                  "name": null,
                  "value": 0.0,
                  "voltage": 0.0,
                  "producer": null,
                  "type": null,
                  "price": null,
                  "amount": 0,
                  "_links": {
                      "self": {
                          "href": "http://localhost:8080/elements/26"
                      },
                      "replacementForElement": {
                          "href": "http://localhost:8080/elements/26/comp?sortBy=ID"
                      }
                  }
              },
              {
                  "id": 40,
                  "name": null,
                  "value": 0.0,
                  "voltage": 0.0,
                  "producer": null,
                  "type": null,
                  "price": null,
                  "amount": 0,
                  "_links": {
                      "self": {
                          "href": "http://localhost:8080/elements/40"
                      },
                      "replacementForElement": {
                          "href": "http://localhost:8080/elements/40/comp?sortBy=ID"
                      }
                  }
              },
              {
                  "id": 76,
                  "name": "Capacitor 470 nF 100V",
                  "value": 4.7E-7,
                  "voltage": 100.0,
                  "producer": "Epcos",
                  "type": "CONDENSER",
                  "price": 1.3,
                  "amount": 8025,
                  "_links": {
                      "self": {
                          "href": "http://localhost:8080/elements/76"
                      },
                      "replacementForElement": {
                          "href": "http://localhost:8080/elements/76/comp?sortBy=ID"
                      }
                  }
              },
              {
                  "id": 65,
                  "name": null,
                  "value": 0.0,
                  "voltage": 0.0,
                  "producer": null,
                  "type": null,
                  "price": null,
                  "amount": 0,
                  "_links": {
                      "self": {
                          "href": "http://localhost:8080/elements/65"
                      },
                      "replacementForElement": {
                          "href": "http://localhost:8080/elements/65/comp?sortBy=ID"
                      }
                  }
              },
              {
                  "id": 22,
                  "name": null,
                  "value": 0.0,
                  "voltage": 0.0,
                  "producer": null,
                  "type": null,
                  "price": null,
                  "amount": 0,
                  "_links": {
                      "self": {
                          "href": "http://localhost:8080/elements/22"
                      },
                      "replacementForElement": {
                          "href": "http://localhost:8080/elements/22/comp?sortBy=ID"
                      }
                  }
              }
          ],
          "_links": {
              "self": {
                  "href": "http://localhost:8080/kits/77"
              }
          }
      }
      ```
      <br><br>


* #### PUT /{id}
    Зміна набору {id} на елемент з body запиту. Id набору з body ігнорується. Якщо елемент {id} не існує повертає код `404 (Not found)`.

    ##### Приклад:            
    * Запит: `PUT http://localhost:8080/kit/2122`
    
        Body запиту:
         ```json
        {
            "name": "testKitName10",
            "producer": "Sparkfun",
            "price": 700.99,
            "elements": [
                {
                    "id": 23
                },
                {
                	"id": 129,
                    "name": "Capacitor 480 nF 100V",
                    "value": 0.00000048,
                    "voltage": 100,
                    "producer": "Epcos",
                    "type": "CONDENSER",
                    "price": 1.3,
                    "amount": 8425
                }
            ]
        }
         ```          
              
        Response status: `404 (Not found)`
           
        Response body: `none`

* #### DELETE /{id}
    Видалення набору {id}. Якщо набір {id} не існує повертає код `404 (Not found)`.

    ##### Приклад:
    * Запит: `DELETE http://localhost:8080/kits/77`
        
        Body запиту: `none`
            
        Response status: `200 (OK)`
            
        Response body: `none` <br><br>
            
    * Запит: `DELETE http://localhost:8080/elements/2122`
    
        Body запиту: `none`
              
        Response status: `404 (Not found)`
           
        Response body: `none`  
        
* #### GET /sortMethods
    Повертає масив всіх критеріїв сортування наборів.

    ##### Приклад:
    * Запит: `GET http://localhost:8080/kits/sortMethods`
    
        Body запиту: `none`
    
        Response status: `200 (OK)`
    
        Response body: 
        ```json
      [
          "ID",
          "NAME",
          "PRODUCER",
          "PRICE"
      ]
      ```          
