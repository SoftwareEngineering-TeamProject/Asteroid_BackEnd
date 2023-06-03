package com.example.todolist.service;

import com.example.todolist.domain.ListEntity;
import com.example.todolist.domain.MemberEntity;
import com.example.todolist.dto.ListRequestDto;
import com.example.todolist.dto.ListResponseDto;
import com.example.todolist.repository.ListRepository;
import com.example.todolist.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    public Long update(ListRequestDto requestDto){
        Optional<ListEntity> list = listRepository.findById(requestDto.getId());
        if(list.isPresent()){
            list.get().setTitle(requestDto.getTitle());
            list.get().setTasks(requestDto.getTasks());
            return list.get().getId();
    }
        else{
        return 0L;
        }
    }
    public Long delete(ListRequestDto requestDto){
        Optional<ListEntity> list = listRepository.findById(requestDto.getId());
        if(list.isPresent()){
            Long listId = list.get().getId();
            listRepository.delete(list.get());
            return listId;
        }
        else{
            return 0L;
        }

    }




}
