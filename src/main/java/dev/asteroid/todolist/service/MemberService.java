package dev.asteroid.todolist.service;

import dev.asteroid.todolist.domain.member.MemberEntity;
import dev.asteroid.todolist.domain.member.MemberRepository;
import dev.asteroid.todolist.dto.member.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(MemberRequestDto requestDto) {
        return memberRepository.save(new MemberEntity(requestDto.getEmail(), requestDto.getPassword())).getId();
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

