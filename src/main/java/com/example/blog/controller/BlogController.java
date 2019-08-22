package com.example.blog.controller;

import com.example.blog.vo.Member;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("blog")
public class BlogController {
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello, Son";
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public Member getInfo() {
        Member member = new Member(1, "Boseok, Son", "qhtjr7789@naver.com");


        return member;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Member> list() {
        List<Member> memberList = Arrays.asList(
               new Member[]{new Member(1,"1Boseok, Son","1qhtjr7789@naver.com") ,
               new Member(2,"2Boseok, Son","2qhtjr7789@naver.com") ,
               new Member(3,"3Boseok, Son","3qhtjr7789@naver.com") ,
               new Member(4,"4Boseok, Son","4qhtjr7789@naver.com") ,
               new Member(5,"5Boseok, Son","5qhtjr7789@naver.com") }

        );
        //test
        long startTime = System.currentTimeMillis();
        for (Member member : memberList){
            System.out.println(member);
        }
        System.out.println("for-loop:" +(System.currentTimeMillis() - startTime) + "ms");

        startTime = System.currentTimeMillis();
        memberList.forEach(System.out::println);
        System.out.println("lambda:" +(System.currentTimeMillis() - startTime) + "ms");
        //test



        return memberList;
    }
}
