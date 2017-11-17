package healthcares.spring.service;

import java.util.List;

import healthcares.spring.model.Color;

public interface ColorService {
	public void add(Color color);
	public void edit(Color color);
	public void delete(int Id);
	public Color getColor(int Id);
	public List getAllColor();
	public List getColoor(String name);
}
