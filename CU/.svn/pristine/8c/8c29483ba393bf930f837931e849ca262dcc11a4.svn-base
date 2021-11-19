package cu.util;

public class Common2 {
	public static int getTextLength(String str) {
		int cnt = 0;
		String[] strs = str.split("");
		for(String s : strs) {
			cnt = s.matches("[가-힣]") || s.charAt(0) >= 9312 && s.charAt(0) <= 9332 ? cnt + 2 : cnt +1;
		}
		return cnt;
	}
	public static String createTextBox(String[] strs) {
		String[] boxArticles = "┌┐└┘─│".split("");
		String ret = boxArticles[0];
		int start = 9312;
		String menus = "";
		for(String s : strs) {
			menus += "" + ((char)start++) + " " + s + " ";
		}
		int length = getTextLength(menus);
		for(int i = 0; i < getTextLength(menus) ; i++) {
			ret += boxArticles[4];
		}
		ret+= boxArticles[1] + "\n" + boxArticles[5] + menus + boxArticles[5] + "\n";
		ret+= boxArticles[2];
		for(int i = 0; i < length ; i++) {
			ret += boxArticles[4];
		}
		ret+=boxArticles[3];
		return ret;
	}
}
