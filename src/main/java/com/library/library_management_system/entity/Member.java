package com.library.library_management_system.entity;

import jakarta.persistence.*;




@Entity
@Table(name="members")
public class Member {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "member_id",length=15)
        private long memberId;

        @Column(name = "member_name",length = 100)
        private String memberName;



        public Member(long memberId,String memberName) {
           this.memberId = memberId;
           this.memberName = memberName;
        }

        public Member(String memberName) {
            this.memberName = memberName;
        }

        public Member(){

        }

    public long getMemberId() {
        return memberId;
    }


    public String getMemberName() {
        return memberName;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                '}';
    }
}
