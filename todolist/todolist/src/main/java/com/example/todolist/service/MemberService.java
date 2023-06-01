package com.example.todolist.service;

import com.example.todolist.domain.MemberEntity;
import com.example.todolist.repository.MemberRepository;
import com.example.todolist.dto.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public Long join(MemberRequestDto requestDto) {
        Optional<MemberEntity> findMember = memberRepository.findByEmail(requestDto.getEmail());
        if(findMember.isEmpty()){
            MemberEntity member = new MemberEntity();
            member.setEmail(requestDto.getEmail());
            member.setPassword(requestDto.getPassword());
            memberRepository.save(member);
            return 0L;
        }
        else{
            return findMember.get().getId();
        }

    }

    public Long check(MemberRequestDto requestDto) {
        Optional<MemberEntity> findMember = memberRepository.findByEmailAndPassword(requestDto.getEmail(), requestDto.getPassword());

        // 로그인 성공
        if(findMember.isPresent()) {
            return findMember.get().getId();
        }

        // 로그인 실패
        return 0L;
    }
}
