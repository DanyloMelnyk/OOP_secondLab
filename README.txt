Лабораторна робота №2 з ООП студента групи КН115 Мельника Данила.

Необхідний JDK 14

Команда для запуску скомпільованої програми "java --enable-preview -jar second-0.0.1-SNAPSHOT.jar".

Main class - src/main/java/ua/lviv/ai/oop_labs/second/SecondOopLabApplication.java

Використовується база даних MySQL8, налаштування в файлі src/main/resources/application.properties

Дамп тестової бази даних з тестовими даними знаходиться в файлі Database.sql

Файл "OOP second lab.postman_collection.json" - тестові запити експортовані з Postman.

Архів INTELLIJ_IDEA.zip - експортований з IntelliJ IDEA проект.


При вникненні помилки при запуску "java.sql.SQLException: The server time zone value '' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the 'serverTimezone' configuration property) to use a more specifc time zone value if you want to utilize time zone support."
в MySQL Workbench необхідно виконати команду "SET @@global.time_zone = '+03:00';"

Доступні запити
/elements/
GET /elements/  - перегляд елементів в каталозі
GET /elements/{id}  - поверає елемент з заданим id
GET /elements/{id}/comp - повертає елементи-замінники елемента {id}
POST /elements/ - додавання до каталогу нового елемента, з body запиту
PUT /elements/{id}  - зміна елемента {id} на елемент з body запиту
DELETE /elements/{id}   - видалення елемента {id}
GET /elements/types - масив всіх типів елементів
GET /elements/sortMethods - масив всіх критеріїв сортування елементів

/kits/
GET /kits/  - перегляд наборів елементів в каталозі
GET /kits/{id}  - набір з заданим id
POST /kits/  - додавання до каталогу нового набору, з body запиту
PUT /kits/{id}  - зміна набору {id} на елемент з body запиту
DELETE /kits/{id}  - видалення набору {id}
GET /kits/sortMethods  - масив всіх критеріїв сортування наборів

Приклад даних у JSON форматі:

Element
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
            "price": 129.99
        }
    ]
}


Kit
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
            "amount": 645
        }
    ]
}

Посилання на GitHub - https://github.com/DanyloMelnyk/OOP_secondLab