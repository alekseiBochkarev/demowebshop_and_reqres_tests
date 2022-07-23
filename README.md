# Проект по автоматизации тестирования API магазина "Demowebshop"
<img title="Wiki img" src="images/demowebshop.png">

#### <a target="_blank" href="http://demowebshop.tricentis.com/">Ссылка на сайт магазина</a>


## :floppy_disk: Содержание:
- <a href="#computer-технологии-и-инструменты">Технологии и инструменты</a>
- <a href="#notebook_with_decorative_cover-реализованные-проверки">Реализованные проверки</a>
- <a href="#arrow_forward-запуск-из-терминала">Запуск из терминала</a>
- <a href="#electric_plug-сборка-в-Jenkins">Сборка в Jenkins</a>
- <a href="#👽-отчет-browserstack">Отчет BrowserStack</a>
- <a href="#open_book-allure-отчет">Allure отчет</a>
- <a href="#hammer-allure-test-ops-отчет">Allure Test Ops отчет</a>
- <a href="#robot-отчет-в-telegram">Отчет в Telegram</a>
- <a href="#film_projector-видео-пример-прохождения-тестов">Видео пример прохождения тестов</a>

## :computer: Технологии и инструменты
<p align="center">
<img width="6%" title="IntelliJ IDEA" src="Documents/qa_guru_12_18_rest/images/logo/Intelij_IDEA.svg">
<img width="6%" title="Java" src="Documents/qa_guru_12_18_rest/images/logo/Java.svg">
<img width="6%" title="Selenide" src="Documents/qa_guru_12_18_rest/images/logo/Selenide.svg">
<img width="6%" title="Appium" src="Documents/qa_guru_12_18_rest/images/logo/appium.svg">
<img width="6%" title="Selenoid" src="Documents/qa_guru_12_18_rest/images/logo/Selenoid.svg">
<img width="6%" title="Allure Report" src="Documents/qa_guru_12_18_rest/images/logo/Allure_Report.svg">
<img width="6%" title="Gradle" src="Documents/qa_guru_12_18_rest/images/logo/Gradle.svg">
<img width="6%" title="JUnit5" src="Documents/qa_guru_12_18_rest/images/logo/JUnit5.svg">
<img width="6%" title="GitHub" src="Documents/qa_guru_12_18_rest/images/logo/GitHub.svg">
<img width="6%" title="Jenkins" src="Documents/qa_guru_12_18_rest/images/logo/Jenkins.svg">
<img width="6%" title="Telegram" src="Documents/qa_guru_12_18_rest/images/logo/Telegram.svg">
</p>

## :notebook_with_decorative_cover: Реализованные проверки
- Проверка онбординга
- Проверка поиска

## :arrow_forward: Запуск из терминала
Локальный запуск:
```
gradle clean test -Denv=local
```
Запуск в Browserstack:
```
gradle clean test -Denv=browserstack
```

## :electric_plug: Сборка в Jenkins
##### <a target="_blank" href="https://jenkins.autotests.cloud/view/C12-BochkarevAlexej/job/C12-BochkarevAlexej-lesson22-mobile-tests/">Сборка в Jenkins</a>
<p align="center">
<img title="Jenkins Dashboard" src="images/jenkinsbuild.png">
</p>  

## 👽 Отчет BrowserStack
Подробности прохождения тестов мы можем увидеть в личном кабинете BrowserStack.
Часто это дает полезную информацию о работе нашего приложения.
<img title="BrowserStack dashboard" src="images/browserstack.png">

## :open_book: Allure отчет
- ### Стартовая страница отчета
<p align="center">
<img title="Allure Overview Dashboard" src="images/allureMain.png">
</p>

- ### Страница с проведенными тестами
<p align="center">
<img title="Allure Test Page" src="images/allureSuites.png">
</p>

## :hammer: Allure Test Ops отчет
<p align="center">
<img title="Allure Test Ops Launch" src="images/allureTestOps.png">
<img title="Allure Test Ops Dashboard" src="images/allureTestOps2.png">
</p>

## :robot: Отчет в Telegram
<p align="center">
<img title="Telegram notification message" src="images/telegramReport.png">
</p>

## :film_projector: Видео пример прохождения тестов
> К каждому тесту в отчете прилагается видео. Одно из таких видео представлено ниже.
<p align="center">
  <img title="Browserstack Video" src="images/gif/alluretestvideo.gif">
</p>