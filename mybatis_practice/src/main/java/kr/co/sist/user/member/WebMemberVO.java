package kr.co.sist.user.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WebMemberVO {
	private String id, password, name, birthday, tel, cell, email1, email2, 
	gender, area, zipcode, addr0, addr1, email, ip, join_date;
}
