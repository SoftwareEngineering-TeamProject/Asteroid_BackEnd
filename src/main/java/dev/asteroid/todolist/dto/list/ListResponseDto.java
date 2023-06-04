package dev.asteroid.todolist.dto.list;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ListResponseDto {

    private String title;

    public ListResponseDto(String title) {
        this.title = title;
    }
}
