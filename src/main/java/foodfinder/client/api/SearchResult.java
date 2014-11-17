package foodfinder.client.api;

import java.io.Serializable;

import org.json.JSONObject;

public class SearchResult implements Serializable {

	private static final long serialVersionUID = -3615529034973885057L;

	private final int id;
	private final String name;
	private final String type;
	private final String brand;
	private final double price;
	private final String description;
	private final int hall;
	private final int shelf;

	public SearchResult(final JSONObject result) {
		id = result.getInt("id");
		name = result.getString("name");
		type = result.getString("type");
		brand = result.getString("brand");
		price = result.getDouble("price");
		description = result.getString("desc");
		hall = result.getInt("hall");
		shelf = result.getInt("shelf");
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getBrand() {
		return brand;
	}

	public double getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public int getHall() {
		return hall;
	}

	public int getShelf() {
		return shelf;
	}

	@Override
	public boolean equals(final Object o) {
		return o instanceof SearchResult && ((SearchResult) o).getId() == id;
	}
}