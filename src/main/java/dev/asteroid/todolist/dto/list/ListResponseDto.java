package dev.asteroid.todolist.dto.list;

import dev.asteroid.todolist.domain.list.ListEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class ListResponseDto {

    private String title;

    private List<ListResponseDto> responseDtoList = new ArrayList<>();  // 엔티티를 DTO 로 변환하여 조회할 때 사용되는 리스트

    public ListResponseDto(String title) {
        this.title = title;
    }

    public ListResponseDto(List<ListEntity> listEntities) {
        for(ListEntity listEntity : listEntities) {  // 엔티티 목록 가져와서
            this.title = listEntity.getTitle();  // DTO 담아서

            responseDtoList.add(new ListResponseDto(title));  // 리스트에 저장 (외부에서 조회 시 Getter 사용)
        }
    }
}
