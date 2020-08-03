package com.capstonesam.springcapstoneplzwebservice.domainForFunction;

import javax.persistence.*;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import lombok.*;

/*
 *@Author : Ayeon
 *@Date : 2019.05.05
 *@Description : Interest_planguage_info table object //관심 언어 정보
*/

@NoArgsConstructor
@Getter
//@Setter
@Entity
@Table(name ="interest_planguage_info")
public class Interest_planguage_info {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long interest_plang_id;

	@Column(nullable = false, length=45)
	private String interest_plang_1;

	@Column(nullable = false, length=45)
	private String interest_plang_2;

	@Column(nullable = false, length=45)
	private String interest_plang_3;

	@ManyToOne
	@JoinColumn(name = "user_num")
	private User_info userinfo;

	@Builder
	public Interest_planguage_info(String interest_planguage_1, String interest_planguage_2, String interest_planguage_3, User_info user_info){
		this.interest_plang_1 = interest_planguage_1;
		this.interest_plang_2 = interest_planguage_2;
		this.interest_plang_3 = interest_planguage_3;
		this.userinfo=user_info;
	}

}
