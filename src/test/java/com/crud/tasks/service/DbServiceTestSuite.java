package com.crud.tasks.service;


import com.crud.tasks.domain.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTestSuite {
    @Autowired
    private DbService dbService;

    @Test
    public void testGetAllTasks() {
        //Given
        List<Task> tasksList=new ArrayList<>();

        //When
        tasksList=dbService.getAllTasks();

        //Then
        assertEquals(3,tasksList.size());
      //  assertEquals(tasksList.get(0).getTitle().equals(""));

    }

/*    @Test
    public void testSaveTask() {
        //Given
        Task testTask = new Task(9L,"testTask", "testContent");
        //When
        int tasksCount=dbService.getAllTasks().size();
        dbService.saveTask(testTask);
        int tasksCount2=dbService.getAllTasks().size();

        //Then
        assertTrue(tasksCount > tasksCount2);

    }*/


}
