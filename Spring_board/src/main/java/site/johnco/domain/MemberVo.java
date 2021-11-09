package site.johnco.domain;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data @Alias("member")
public class MemberVo {
	private String userid;
	private String userpw;
	private String userName;
	private boolean enabled;
	
	private Date regDate;
	private Date updateDate;
	private List<AuthVo> auths;
}
