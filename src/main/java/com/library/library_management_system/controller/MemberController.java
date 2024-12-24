package com.library.library_management_system.controller;
import com.library.library_management_system.dto.*;
import com.library.library_management_system.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;


    @PostMapping("/addMember")  //For add a new member
    public ResponseEntity<String> addMember(@RequestBody MemberAddDTO memberAddDTO) {
        String memberName;
        try {
            memberName = memberService.addMember(memberAddDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully added new member: " + memberName);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "An error occurred while adding new member: " + e.getMessage());
        }

    }

    @GetMapping( "/getAllMembers")   //For Retrieve all members
    public ResponseEntity<List<MemberDTO>> getAllMembers(){


        try {
            List<MemberDTO> allMembers = memberService.getAllMembers();
            return  ResponseEntity.ok(allMembers);

        } catch (Exception e) {
            System.out.println("An error occurred while getting all members"+e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }

    }

    @GetMapping( "/getMember/{id}")  //For Retrieve a member by id
    public ResponseEntity<String> getMember(@PathVariable Long id) {

        try {
            String memberName = memberService.getMember(id);
            return  ResponseEntity.ok("Successfully get member: " + memberName);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "An error occurred while Retrieving an exiting member: " + e.getMessage());
        }

    }
    @PutMapping( "/updateMember/{id}")  //For Update an existing member
    public ResponseEntity<String> updateMember(@PathVariable Long id , @RequestBody MemberUpdateDTO memberUpdateDTO) {


        try {
          String updateMember = memberService.updateMember(id,memberUpdateDTO);
            return ResponseEntity.ok("Successfully updated member: " + updateMember);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( "An error occurred while updating an exiting member: " + e.getMessage());
        }

    }



    @DeleteMapping( "/deleteMember/{id}")  //For Delete a member
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {

        try {
            String memberName;
            memberName = memberService.deleteMember(id);
            return ResponseEntity.ok("Successfully deleted  member: " + memberName);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred while deleting an exiting member: " + e.getMessage());
        }

    }

}
