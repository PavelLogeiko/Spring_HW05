package com.example.Spring_HW05.repositories;

import com.example.Spring_HW05.domain.Task;
import com.example.Spring_HW05.status.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Репозиторий для задач
 */
public interface TaskRepository extends JpaRepository<Task, Long> {

    /**
     * Принимает задачи по статусу
     * @param status Статус задачи
     * @return Список задач со статусом
     */

    List<Task> findByStatus(TaskStatus status);
}