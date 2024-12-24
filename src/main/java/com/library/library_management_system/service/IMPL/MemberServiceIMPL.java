package com.library.library_management_system.service.IMPL;
import com.library.library_management_system.dto.MemberAddDTO;
import com.library.library_management_system.dto.MemberDTO;
import com.library.library_management_system.dto.MemberUpdateDTO;
import com.library.library_management_system.entity.Member;
import com.library.library_management_system.repository.MemberRepository;
import com.library.library_management_system.service.MemberService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service

public class MemberServiceIMPL implements MemberService {
    @Autowired
    private MemberRepository memberRepository;
    @Override
    public String addMember(MemberAddDTO memberAddDTO) {
        Member member = new Member(
                memberAddDTO.getMemberName());
        memberRepository.save(member);
        return member.getMemberName();
    }

    @Override
    public List<MemberDTO> getAllMembers() {

            List<Member> getMembers = memberRepository.findAll();
            List<MemberDTO> memberDTOList= new ArrayList<>();


            for(Member member : getMembers) {
                MemberDTO memberDTO = new MemberDTO(
                       member.getMemberId(),
                        member.getMemberName()
                );
                memberDTOList.add(memberDTO);
            }
            return memberDTOList;
        }
@Override
    public String updateMember(Long memberId, MemberUpdateDTO memberUpdateDTO) {
        if(memberRepository.existsById(memberId)){
           Member member = memberRepository.getReferenceById((memberId));
            member.setMemberName(memberUpdateDTO.getMemberName());
            memberRepository.save(member);
            return member.getMemberName();
        }else{
            throw new EntityNotFoundException("Member not found");

        }
    }

    @Override
    public String deleteMember(Long id) {
        if(memberRepository.existsById(id)) {
            Member member = memberRepository.getReferenceById(id);
            String memberName = member.getMemberName();
           memberRepository.deleteById(id);
           return memberName;

        } else{
            throw new EntityNotFoundException("Member not found for id : " + id);
        }


    }

    @Override
    public String getMember(Long id) {
        if(memberRepository.existsById(id)) {
            Member member = memberRepository.getReferenceById((long) id);
            return member.getMemberName();
        } else{
            throw new EntityNotFoundException("The member not found");
        }



    }

}


