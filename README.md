# Барахолка.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white "Java 17")
![Maven](https://img.shields.io/badge/Maven-green.svg?style=for-the-badge&logo=mockito&logoColor=white "Maven")
![Spring](https://img.shields.io/badge/Spring-blueviolet.svg?style=for-the-badge&logo=spring&logoColor=white "Spring")
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![GitHub](https://img.shields.io/badge/git-%23121011.svg?style=for-the-badge&logo=github&logoColor=white "Git")

## Описание:
Веб приложение по перепродаже различных вещей.

## Основной функционал:
* Авторизация и аутентификация пользователей.
* Распределение ролей между пользователями: пользователь и администратор.
* CRUD-операции для объявлений и комментариев: 
  * администратор может удалять или редактировать все объявления и комментарии,
  * пользователи — только свои.
* Возможность для пользователей оставлять комментарии под каждым объявлением.
* Показ и сохранение картинок объявлений, а также аватарок пользователей.


## Запуск приложения:
1) Загрузи проект
2) Для проекта создана фронтенд-часть. Для ее запуска выполни следующую команду:
```
docker run -d -p 3000:3000 --rm ghcr.io/bizinmitya/front-react-avito:v1.19
```
3) Используй следующие команды для запуска docker-compose файла:
```
docker-compose build
```
затем
```
docker-compose up
```
4) После выполнения всех пунктов можно будет зайти через браузер по адресу: http://localhost:3000

## Техническое задание:
Нужно написать бэкенд-часть сайта на Java.

Бэкенд-часть проекта предполагает реализацию следующего функционала:
* Авторизация и аутентификация пользователей.
* Распределение ролей между пользователями: пользователь и администратор.
* CRUD-операции для объявлений и комментариев: администратор может удалять или редактировать все объявления и комментарии, а пользователи — только свои.
* Возможность для пользователей оставлять комментарии под каждым объявлением.
* Показ и сохранение картинок объявлений, а также аватарок пользователей.

## Дополнительная информация:
* срок выполнения: 6 недель
* старт проекта: 2023.10.16

## Команда разработчиков:
* [Камко Р.](https://github.com/Roman-Kamko)
* [Никитин Н.](https://github.com/NikitinNikita94)
* [Волынкина А.](https://github.com/ModelS87)
* [Назаренко А.](https://github.com/hyperpositron)
* [Березкин А.](https://github.com/a7479)

## Стек технологий:
* Язык: _Java 17_
* Фреймворк: _Spring_
    * _spring-boot_
    * _spring-data-jpa_
    * _spring-validation_
    * _spring-security_
* Сборщик проекта: _Maven_
* База данных: _PostgreSQL_
* Система управления миграциями: _Liquibase_
* Контейнеризация: _Docker_
* Контроль версий: _Git_