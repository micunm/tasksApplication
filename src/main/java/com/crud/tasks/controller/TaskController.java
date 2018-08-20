package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET, value="getTasks")
    public List<TaskDto> getTasks() {
        return taskMapper.mapToTaskDtoList(service.getAllTasks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTask")
    public TaskDto getTask(@RequestParam(name = "taskId") Long taskId) throws TaskNotFoundException {
        return taskMapper.mapToTaskDto(service.getTask(taskId).orElseThrow(TaskNotFoundException::new));
        //return new TaskDto(1L, "test title", "test_content");
    }

    @RequestMapping(method = RequestMethod.DELETE, value="deleteTask" )
    public void deleteTask(@RequestParam(name = "taskId") Long taskId) {
        service.deleteTask(taskId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
    public TaskDto updateTask(@RequestBody TaskDto taskDto) {
        return taskMapper.mapToTaskDto(service.saveTask(taskMapper.mapToTask(taskDto)));
//        return new TaskDto(1L, "Edited test title", "Test content");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTask", consumes=APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody TaskDto taskDto) {
        service.saveTask(taskMapper.mapToTask(taskDto));
    }

    // GET request
    @RequestMapping(method=RequestMethod.GET, value="getTrelloBoards")
    public void getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.forEach(trelloBoardDto -> {

            System.out.println(trelloBoardDto.getName() + " - " + trelloBoardDto.getId());

            System.out.println("This board contains lists: ");

            trelloBoardDto.getLists().forEach(trelloList ->
                    System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));

        });
    }

}
