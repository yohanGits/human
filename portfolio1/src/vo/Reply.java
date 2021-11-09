package vo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply {
	private Long rno;
	private String title;
	private String content;
	private String regDate;
	private String id;
	private Long bno;
	
	public Reply(Long rno, String title, String content) {
		super();
		this.rno = rno;
		this.title = title;
		this.content = content;
	}
	
	
}
