package com.capstonesam.springcapstoneplzwebservice.domainForFunction;

import javax.persistence.*;

import com.capstonesam.springcapstoneplzwebservice.domain.Login.User_info;
import lombok.*;

/*
 *@Author : Ayeon
 *@Date : 2019.05.05
 *@Description : Interest_job_info table object //관심 직무 정보
*/

@NoArgsConstructor
@Getter
@Entity
@Table(name = "interest_job_info")
public class Interest_job_info {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long interest_job_ID; //관심 직무

	@Column(nullable = false, length=45)
	private String interest_job_1 ;

	@Column(nullable = false, length=45)
	private String interest_job_2 ;

	@Column(nullable = false, length=45)
	private String interest_job_3 ;

	@ManyToOne
	@JoinColumn(name = "user_num")
	private User_info userinfo;


	@Builder
	public Interest_job_info(String interest_job_1, String interest_job_2, String interest_job_3, User_info user_info){
		this.interest_job_1 = interest_job_1;
		this.interest_job_2 = interest_job_2;
		this.interest_job_3 = interest_job_3;
		this.userinfo=user_info;
	}

}
