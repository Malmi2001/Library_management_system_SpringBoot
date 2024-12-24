package com.library.library_management_system.service;

import com.library.library_management_system.dto.MemberAddDTO;
import com.library.library_management_system.dto.MemberDTO;
import com.library.library_management_system.dto.MemberUpdateDTO;


import java.util.List;

public interface MemberService {
    String addMember(MemberAddDTO memberAddDTO);

    List<MemberDTO> getAllMembers();

    String updateMember(Long id, MemberUpdateDTO memberUpdateDTO);

    String deleteMember(Long id);

    String getMember(Long id);
}
