# Проект по автоматизации тестирования API магазина "Demowebshop" и рест-сервиса "Reqres.in"
<img title="demowebshop img" src="images/demowebshop.png">
<img title="reqres img" src="images/reqresIn.png">

#### <a target="_blank" href="http://demowebshop.tricentis.com/">Ссылка на сайт магазина</a>
#### <a target="_blank" href="https://reqres.in/">Ссылка на сайт сервиса</a>


## :floppy_disk: Содержание:
- <a href="#computer-технологии-и-инструменты">Технологии и инструменты</a>
- <a href="#notebook_with_decorative_cover-реализованные-проверки">Реализованные проверки</a>
- <a href="#arrow_forward-запуск-из-терминала">Запуск из терминала</a>
- <a href="#electric_plug-сборка-в-Jenkins">Сборка в Jenkins</a>
- <a href="#open_book-allure-отчет">Allure отчет</a>
- <a href="#hammer-allure-test-ops-отчет">Allure Test Ops отчет</a>
- <a href="#robot-отчет-в-telegram">Отчет в Telegram</a>
- <a href="#film_projector-видео-пример-прохождения-тестов">Видео пример прохождения тестов</a>

## :computer: Технологии и инструменты
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="images/logo/Java.svg">
<img width="6%" title="Selenide" src="images/logo/Selenide.svg">
<img width="6%" title="Appium" src="images/logo/appium.svg">
<img width="6%" title="Selenoid" src="images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="images/logo/Telegram.svg">
</p>

## :notebook_with_decorative_cover: Реализованные проверки
- Проверка авторизации
- Проверка добавления товара в корзину
- Проверка рест запроса на получение списка пользователей
- Проверка рест запроса на получение пользователя
- Негативная проверка рест запроса на получение пользователя
- Проверка рест запроса на создание сущности
- Проверка рест запроса на обновление сущности

## :arrow_forward: Запуск из терминала
Локальный запуск:
```
gradle clean test -Dweb=local
```
Запуск в Browserstack:
```
gradle clean test -Dweb=remote
```

## :electric_plug: Сборка в Jenkins
##### <a target="_blank" href="https://jenkins.autotests.cloud/view/C12-BochkarevAlexej/job/C12-BochkarevAlexej-lesson18/">Сборка в Jenkins</a>
<p align="center">
<img title="Jenkins Dashboard" src="images/jenkinsrest.png">
</p>  

## :open_book: Allure отчет
- ### Стартовая страница отчета
<p align="center">
<img title="Allure Overview Dashboard" src="images/allureRest.png">
</p>

- ### Страница с проведенными тестами
<p align="center">
<img title="Allure Test Page" src="images/allureRestsuites.png">
</p>

- ### Страница с диаграммами
<p align="center">
<img title="Allure Diagram Page" src="images/allreRestgraphs.png">
</p>


## :hammer: Allure Test Ops отчет
<p align="center">
<img title="Allure Test Ops Launch" src="images/allureTestOpsLaunchRest.png">
<img title="Allure Test Ops Dashboard" src="images/allureTODashboard.png">
</p>

## :robot: Отчет в Telegram
<p align="center">
<img title="Telegram notification message" src="images/telegramrest.png">
</p>

## :film_projector: Видео пример прохождения тестов
> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
<p align="center">
  <img title="Browserstack Video" src="images/gif/shopVideo.gif">
</p>