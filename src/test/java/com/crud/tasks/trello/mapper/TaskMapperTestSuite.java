package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void testMapToTask() {
        //Given
        TaskDto taskDto=new TaskDto(4L,"test_TaskDto","test_content");

        //When
        Task testTask=taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(testTask.getContent(), "test_content");
        assertEquals(testTask.getTitle(), "test_TaskDto");
   //     assertEquals(testTask.getId(),4);
    }

    @Test
    public void testMapToTaskDto() {
        //Given
        Task task=new Task(4L,"test_TaskDto","test_content");

        //When
        TaskDto testTaskDto=taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(testTaskDto.getContent(), "test_content");
        assertEquals(testTaskDto.getTitle(), "test_TaskDto");
    }

    @Test
    public void testMapToTaskDtoList() {
        //Given
        List<Task> tasksList = new ArrayList<>();
        tasksList.add(new Task(4L,"test_Task","test_content"));
        tasksList.add(new Task(5L,"test_Task2","test_content2"));
        tasksList.add(new Task(6L,"test_Task3","test_content3"));

        //When
        List <TaskDto> testTasksListDto=taskMapper.mapToTaskDtoList(tasksList);

        //Then
        assertEquals(testTasksListDto.size(), 3);
        assertEquals(testTasksListDto.get(0).getTitle(), "test_Task");
    }
}
