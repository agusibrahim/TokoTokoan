package ai.agusibrhim.design.topedc.Model;
import java.util.*;

public class ProductHorizontal
{
	public String title;
	public List<Product> products;
	public int catid;

	public ProductHorizontal(String title, List<Product> products, int catid) {
		this.title = title;
		this.products = products;
		this.catid = catid;
	}
}
