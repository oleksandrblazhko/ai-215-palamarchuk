### Опис процесу створення докер контейнера

Для того щоб завантажити image постгресу необхідно виконати команду

``` powershell
docker pull postgres:latest
```

Для створимо скріпт який би заповнив базу даними та розмістимо його у ~/scripts/db_script.sql. Скріпт виглядає:

``` sql
CREATE TABLE users (
    name VARCHAR(255)
);

INSERT INTO users VALUES 
                     ('user1'),
                     ('user2'),
                     ('user3'),
                     ('user4');

SELECT * FROM users;
```

Далі необхідно виконати команду:

``` powershell
docker run `
  --name palamarchuk-postgres `
  -p 5455:5432 `
  -e POSTGRES_PASSWORD=1234 `
  -v "${PWD}\scripts:/scripts" `
  -w /scripts `
  -d --rm `
  postgres
```

Опис параметрів\:
 * --name palamarchuk-postgres - Призначає ідентифікатор palamarchuk-postgres. Далі до цього контейнера можна звертатися за ним, а не за хешем який видно через `docker ps`
 * -p 5455:5432- Проброс порту: зовнішній порт 5455 на вашій машині зв’язується з портом 5432 всередині контейнера.
 * -e POSTGRES_PASSWORD=1234 - Встановлює змінну середовища POSTGRES_PASSWORD у контейнері зі значенням 1234 – це пароль суперкористувача postgres.
 * -v "${PWD}\scripts:/scripts" - Монтує локальну папку scripts (з поточного робочого каталогу) в контейнер за шляхом /scripts.
 * -w /scripts - Встановлює робочий каталог контейнера на /scripts
 * -d - Запускає контейнер у фоновому режимі, тобто не блокуючи термінал.
 * --rm - Автоматично видаляє контейнер після його зупинки, щоб не засмічувати систему непотрібними артефактами.
 * postgres - Назва Docker-образу, з якого створюється контейнер. Власне його ми і підтягнули першою командою.

Щоб запустити bash термінал треба виконати:

``` powershell
docker exec -it palamarchuk-postgres bash
```

Далі уже в терміналі треба створити базу та запустити скріпт який там вже є. Для цього треба виконати:

``` bash
createdb palamarchuk-db -U postgres
psql -U postgres -d palamarchuk-db < db_script.sql
```

Далі щоб вийти з bash терміналу контейнера треба написати:

``` bash
exit
```

і в кінці для зупинки контейнеру:

``` powershell
docker stop palamarchuk-postgres
```
