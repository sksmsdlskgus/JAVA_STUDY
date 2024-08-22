package com.ohgiraffers.section02.column;

import jakarta.persistence.*;


import java.util.Date;

@Entity(name="member_section02") // 엔티티 객체로 만들기 위한 어노테이션, 다른 패키지에 동일한 이름이 있으면 안됨
@Table(name="tbl_member_section02") // 데이터베이스에 매핑 될 테이블 이름 설정
public class Member {

    @Id                     // PK에 해당하는 속성에 지정(복합키일 경우 두가지 방식 존재(이후에 다룰 예정))
    @Column(name="member_no")  // 데이터베이스에 대응되는 컬럼명 지정(타입 및 여러 제약조건 설정 가능)
    private int memberNo;

    @Column(name="member_id")
    private String memberId;

    @Column(name="member_pwd")
    private String memberPwd;

    @Column(name="nickname")
    private String nickname;

    @Column(name="phone", columnDefinition = "varchar(200) default '010-000-0000'")
    private String phone;

    @Column(name="email", unique = true)
    private String email;

    @Column(name="address", nullable = false)
    private String address;

    @Column(name="enroll_date")
//    @Temporal(TemporalType.TIMESTAMP)     // datetime
//    @Temporal(TemporalType.DATE)      // date
    @Temporal(TemporalType.TIME)        // time
    private java.util.Date enrollDate;

    @Column(name="member_role")
    private String memberRole;

    @Column(name="status")
    private String status;

    public Member() {
    }

    public Member(int memberNo, String memberId, String memberPwd, String nickname, String phone, String email, String address, Date enrollDate, String memberRole, String status) {
        this.memberNo = memberNo;
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.nickname = nickname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.enrollDate = enrollDate;
        this.memberRole = memberRole;
        this.status = status;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Date getEnrollDate() {
        return enrollDate;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public String getStatus() {
        return status;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setMemberPwd(String memberPwd) {
        this.memberPwd = memberPwd;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEnrollDate(Date enrollDate) {
        this.enrollDate = enrollDate;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                ", memberPwd='" + memberPwd + '\'' +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", enrollDate=" + enrollDate +
                ", memberRole='" + memberRole + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}