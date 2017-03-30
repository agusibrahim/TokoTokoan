package ai.agusibrhim.design.topedc.Model;
import java.util.List;

public class Card
{
	public List<Category> cats;
	public String title, footer, footer_link;

	public Card(List<Category> cats, String title, String footer, String footer_link) {
		this.cats = cats;
		this.title = title;
		this.footer = footer;
		this.footer_link = footer_link;
	}
}
