## Фреймворк Spring (семинары)

### Урок 5. Spring Data для работы с базами данных

Базовое задание:

Условие:

Вам предстоит создать приложение для управления списком задач с 

использованием Spring Boot и Spring Data JPA. 

Требуется реализовать следующие функции:

- Добавление задачи.

- Просмотр всех задач.

- Просмотр задач по статусу (например, "завершена", "в процессе", "не начата").

- Изменение статуса задачи.

- Удаление задачи.

Репозитроий подсказка public interface TaskRepository extends JpaRepository<Task, Long>

Структура задачи(класс Task):
- ID (автоинкрементное)(тип Long)
- Описание (не может быть пустым)(тип String)
- Статус (одно из значений: "не начата", "в процессе", "завершена")(Тип TaskStatus )
- Дата создания (автоматически устанавливается при создании задачи)(Тип LocalDateTime)

Подсказка понадобится энумератор:
enum TaskStatus {
NOT_STARTED, IN_PROGRESS, COMPLETED;

Скрины работы приложения:

![1](https://github.com/PavelLogeiko/Spring_HW05/blob/main/images/1.png)


![2](https://github.com/PavelLogeiko/Spring_HW05/blob/main/images/2.png)


![3](https://github.com/PavelLogeiko/Spring_HW05/blob/main/images/3.png)

