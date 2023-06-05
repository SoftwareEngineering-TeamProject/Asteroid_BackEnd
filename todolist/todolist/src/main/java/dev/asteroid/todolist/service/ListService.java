package dev.asteroid.todolist.service;

import dev.asteroid.todolist.domain.ListEntity;
import dev.asteroid.todolist.domain.MemberEntity;
import dev.asteroid.todolist.dto.ListResponseDto;
import dev.asteroid.todolist.repository.ListRepository;
import dev.asteroid.todolist.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ListService {

    @Autowired
    ListRepository listRepository;
    @Autowired
    MemberRepository memberRepository;

    public Long register(Long memberId,String title){
        Optional<MemberEntity> member = memberRepository.findById(memberId);
        ListEntity list = new ListEntity();
        list.setTitle(title);
        list.setMember(member.get());
        System.out.println("title :" + title);
        listRepository.save(list);

        return 1l;

    }
    public List<ListResponseDto> read(Long memberId){
        Optional<MemberEntity> member = memberRepository.findById(memberId);
        List<ListEntity> lists = member.get().getLists();
        List<ListResponseDto> listResponseDtos = new ArrayList<>();
        for(ListEntity list : lists){
            ListResponseDto dto = new ListResponseDto();
            dto.setId(list.getId());
            dto.setTitle(list.getTitle());
            dto.setTasks(list.getTasks());
            listResponseDtos.add(dto);
        }
        return listResponseDtos;
    }

    public Long update(Long listId,ListResponseDto requestDto){
        Optional<ListEntity> list = listRepository.findById(listId);
        if(list.isPresent()){
            list.get().setTitle(requestDto.getTitle());
            list.get().setTasks(requestDto.getTasks());
            return list.get().getId();
    }
        else{
        return 0L;
        }
    }
    public Long delete(Long listId){
        Optional<ListEntity> list = listRepository.findById(listId);
        if(list.isPresent()){
            listRepository.delete(list.get());
            return listId;
        }
        else{
            return 0L;
        }

    }




}
