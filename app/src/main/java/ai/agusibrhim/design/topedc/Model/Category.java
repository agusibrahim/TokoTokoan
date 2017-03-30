package ai.agusibrhim.design.topedc.Model;

public class Category
{
	public int catid, icres;
	public String title;
	public boolean isBig;

	public Category(int catid, int icres, String title, boolean isBig) {
		this.catid = catid;
		this.icres = icres;
		this.title = title;
		this.isBig = isBig;
	}
}
