package com.crud.tasks.mapper;

@Component
public class TrelloMapper {
    public List<TrelloBoard> mapToBoards(final List<TrelloBoardDto> trelloBoardDto) {
        return trelloBoardDto.stream()
                .map(trelloBoard ->
                        new TrelloBoard(trelloBoard.getName(), trelloBoard.getId(), trelloBoard.getLists()))
                .collect(Collectors.toList());
    }
    public List<TrelloBoardDto> mapToBoardsDto(final List<TrelloBoard> trelloBoards) {
        return trelloBoards.stream()
                .map(trelloBoard ->
                        new TrelloBoardDto(trelloBoard.getName(), trelloBoard.getId(), trelloBoard.getLists()))
                .collect(Collectors.toList());
    }
    public List<TrelloList> mapToList(final List<TrelloListDto> trelloListDto) {
        return trelloListDto.stream()
                .map(t -> new TrelloList(t.getId(), t.getName(), t.isClosed()))
                .collect(Collectors.toList());
    }
    public List<TrelloListDto> mapToListDto(final List<TrelloList> trelloLists) {
        return trelloLists.stream()
                .map(trelloList ->
                        new TrelloListDto(trelloList.getId(), trelloList.getName(), trelloList.isClosed()))
                .collect(Collectors.toList());
    }
    public TrelloCardDto mapToCardDto(TrelloCard trelloCard) {
        return new TrelloCardDto(trelloCard.getName(), trelloCard.getDescription(),
                trelloCard.getPos(), trelloCard.getListId());
    }
    public TrelloCard mapToCard(TrelloCardDto trelloCardDto) {
        return new TrelloCard(trelloCardDto.getName(), trelloCardDto.getDescription(),
                trelloCardDto.getPos(), trelloCardDto.getListId());
    }
}
