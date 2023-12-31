# Diplom_3
## О проекте
Тестирование веб-приложения [Stellar Burgers](https://stellarburgers.nomoreparties.site/) в браузерах Google Chrome и Яндекс.Браузере.

## Технологии в проекте
|                  | версия |
|------------------|--------|
| Java             | 11     |
| JUnit            | 4.13.2 |
| Maven            | 4.0.0  |
| Selenium         | 4.11.0 |
| Allure           | 2.21.0 |

## Как запустить
<ol>
<li>Клонируй репозиторий</li>

```
git clone https://github.com/klirovskij/Diplom_3
```
<li>Google Chrome:</li>
<ol><li>Для запуска тестов</li>

```
mvn clean test
```
<li>Для просмотра отчета в Allure</li>

```
mvn allure:serve
```
</ol>
<li>Яндекс.Браузер:</li>
<ol>
<li>Для запуска тестов</li>

```
mvn clean test -P yandex
```
<li>Для просмотра отчета в Allure</li>

```
mvn allure:serve -P yandex
```
</ol>
</ol>