package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("1", "testListDto", false));
        trelloBoardDto.add(new TrelloBoardDto("1","testBoardDto", trelloListDto));
        //When
        List<TrelloBoard> trelloBoard = trelloMapper.mapToBoards(trelloBoardDto);
        boolean testResult = false;
        if(trelloBoard.get(0).getName().equals("testBoardDto") && trelloBoard.get(0).getId().equals("1") &&
                trelloBoard.get(0).getLists().get(0).getName().equals("testListDto")) {
            testResult = true;
        }
        //Then
        TestCase.assertEquals(testResult,true);
        assertEquals(1, trelloBoard.size());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoard = new ArrayList<>();
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("1", "testList", false));
        trelloBoard.add(new TrelloBoard("1","testBoard", trelloList));
        //When
        List<TrelloBoardDto> trelloBoardDto = trelloMapper.mapToBoardsDto(trelloBoard);
        boolean testResult = false;
        if(trelloBoardDto.get(0).getName().equals("testBoard") && trelloBoardDto.get(0).getId().equals("1") &&
                trelloBoardDto.get(0).getLists().get(0).getName().equals("testList")) {
            testResult = true;
        }
        //Then
        assertTrue(testResult);
        assertEquals(1, trelloBoardDto.size());
    }

    @Test
    public void testMapToList() {
        //Given
        List<TrelloListDto> trelloListDto = new ArrayList<>();
        trelloListDto.add(new TrelloListDto("1", "testListDto", false));
        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListDto);
        boolean testResult = false;
        if(trelloLists.get(0).getId().equals("1") && trelloLists.get(0).getName().equals("testListDto") &&
                !trelloLists.get(0).isClosed()) {
            testResult = true;
        }
        //Then
        assertEquals(1, trelloLists.size());
        assertTrue(testResult);
    }

    @Test
    public void testMapToListDto() {
        //Given
        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList("1", "testList", false));
        //When
        List<TrelloListDto> trelloListDto = trelloMapper.mapToListDto(trelloList);
        boolean testResult = false;
        if(trelloList.get(0).getId().equals("1") && trelloList.get(0).getName().equals("testList") &&
                !trelloList.get(0).isClosed()) {
            testResult = true;
        }
        //Then
        assertEquals(1, trelloList.size());
        assertTrue(testResult);
    }

    @Test
    public void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("testCard", "testDescription", "top", "1");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        boolean testResult = false;
        if(trelloCardDto.getName().equals("testCard") && trelloCardDto.getDescription().equals("testDescription") &&
                trelloCardDto.getPos().equals("top") && trelloCardDto.getListId().equals("1")) {
            testResult = true;
        }
        //Then
        assertTrue(testResult);
    }

    @Test
    public void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("testCardDto", "testDescription", "top", "1");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        boolean testResult = false;
        if(trelloCard.getName().equals("testCardDto") && trelloCard.getDescription().equals("testDescription") &&
                trelloCard.getPos().equals("top") && trelloCard.getListId().equals("1")) {
            testResult = true;
        }
        //Then
        assertTrue(testResult);
    }
}
