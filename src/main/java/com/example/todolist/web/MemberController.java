package com.example.todolist.web;

import com.example.todolist.dto.MemberRequestDto;
import com.example.todolist.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class MemberController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/join")
    public ResponseEntity joinMember(@RequestBody MemberRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.join(requestDto));
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity loginMember(@RequestBody MemberRequestDto requestDto, HttpServletRequest request) {
        Long memberId = memberService.check(requestDto);

        // 로그인 성공
        if(memberId != 0L) {
            HttpSession session = request.getSession();
            session.setAttribute("currentMember", memberId);

            Long currentMember = (Long) session.getAttribute("currentMember");
            System.out.println("currentMember = " + currentMember);

            return ResponseEntity.status(HttpStatus.CREATED).body(memberId);
        }

        // 로그인 실패
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}

