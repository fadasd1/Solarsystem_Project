package classes;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class PlanetContainer {
	private List<Planet> planets;
	private List<PlanetView> planetViews;

	public PlanetContainer(List<Planet> planets) {
		this.planets = planets;
		planetViews = new ArrayList<>(planets.size());
		planetViewsInitializer();
	}

	private void planetViewsInitializer() {
		for(Planet p : planets) {
			planetViews.add(new PlanetView(p, colorer(p)));
		}
	}

	public void add(Planet p) {
		planets.add(p);
		planetViews.add(new PlanetView(p, colorer(p)));
	}

	public List<Planet> getPlanets() {
		return planets;
	}

	public List<PlanetView> getPlanetViews() {
		return planetViews;
	}
	private static Color colorer(Planet p) {
		Color color;
		switch(p.getName()) {
			case "Earth" -> color = Color.AQUAMARINE;
			case "Sun" -> color = Color.YELLOW;
			case "Mercury" -> color = Color.DARKGREY;
			case "Moon" -> color = Color.GREY;
			case "Mars" -> color = Color.RED;
			case "Saturn" -> color = Color.LIGHTYELLOW;
			case "Jupiter" -> color = Color.ORANGE;
			case "Neptune" -> color = Color.DEEPSKYBLUE;
			case "Venus" -> color = Color.LIGHTGOLDENRODYELLOW;

			default -> color = Color.GHOSTWHITE;
		}
		return color;
	}

}
