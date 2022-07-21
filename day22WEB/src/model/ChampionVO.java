package model;

public class ChampionVO {
	private int mid;
	private String name;
	private int win;
	private int pick;
	private int ban;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getPick() {
		return pick;
	}
	public void setPick(int pick) {
		this.pick = pick;
	}
	public int getBan() {
		return ban;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}
	@Override
	public String toString() {
		return "MemberVO [mid=" + mid + ", name=" + name + ", win=" + win + ", pick=" + pick + ", ban=" + ban + "]";
	}
}
