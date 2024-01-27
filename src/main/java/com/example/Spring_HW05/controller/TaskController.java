package com.example.Spring_HW05.controller;

import com.example.Spring_HW05.domain.Task;
import com.example.Spring_HW05.repositories.TaskRepository;
import com.example.Spring_HW05.status.TaskStatus;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskRepository taskRepository;

    /**
     * Конструктор для TaskControlle
     * @param taskcontroller Репозиторий Task
     */

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;

    }
    /**
     * Добавление новой задачи (Task)
     * @param task Новая задача
     * @return Добавленная задача
     */

    @PostMapping
    public Task addTask(@RequestBody Task task) {
        task.setCreatedDate(LocalDateTime.now());
        return taskRepository.save(task);
    }

    /**
     * Получение задач
     * @return Cписок задач
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Получение задач по статусу
     * @return Cписок задач с указанным статусом
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    /**
     * Обновление статуса задач
     * @param id ID задачи
     * @param task Задача с обновленным статусом
     * @return Список задач с обновленным статусом
     */

    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
                    task.setStatus(updatedTask.getStatus());
                    return taskRepository.save(task);})
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));
    }

    /**
     * Удаление задач
     * @param id ID задачи
     * @return Список задач после удаления задачи
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}