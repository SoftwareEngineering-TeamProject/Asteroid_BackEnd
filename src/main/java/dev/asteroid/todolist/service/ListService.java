package dev.asteroid.todolist.service;

import dev.asteroid.todolist.domain.list.ListEntity;
import dev.asteroid.todolist.domain.list.ListRepository;
import dev.asteroid.todolist.dto.list.ListRequestDto;
import dev.asteroid.todolist.dto.list.ListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ListService {

    private final ListRepository listRepository;

    @Transactional
    public Long save(ListRequestDto requestDto) {
        return listRepository.save(requestDto.toEntity()).getId();
    }

    public List<ListResponseDto> findAllInCurrent(Long userId) {
        List<ListEntity> listEntities = listRepository.findAllInCurrent(userId).get();
        ListResponseDto responseDto = new ListResponseDto(listEntities);  // 조회한 엔티티들을 모두 DTO 로 변환
        return responseDto.getResponseDtoList();
    }

    public ListResponseDto findById(Long listId) {
        Optional<ListEntity> optionalList = listRepository.findById(listId);
        ListResponseDto responseDto = new ListResponseDto();
        if(optionalList.isPresent()) {
            responseDto = new ListResponseDto(optionalList.get().getTitle());
        }
        return responseDto;
    }

    @Transactional
    public Long update(Long listId, ListRequestDto requestDto) {
        ListEntity listEntity = listRepository.findById(listId).get();
        listEntity.setTitle(requestDto.getTitle());
        return listEntity.getId();
    }

    @Transactional
    public void delete(Long listId) {
        listRepository.deleteById(listId);
    }
}
