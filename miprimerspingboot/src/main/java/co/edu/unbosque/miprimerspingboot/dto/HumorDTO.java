package co.edu.unbosque.miprimerspingboot.dto;

public class HumorDTO {
	private int id;
	private String joke;

	public HumorDTO() {
		// TODO Auto-generated constructor stub
	}

	public HumorDTO(String joke) {
		super();
		this.joke = joke;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJoke() {
		return joke;
	}

	public void setJoke(String joke) {
		this.joke = joke;
	}

	@Override
	public String toString() {
		return "HumorDTO [id=" + id + ", joke=" + joke + "]";
	}

}
