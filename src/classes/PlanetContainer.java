package classes;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Holds and manages a collection of {@link Planet} objects along with their corresponding
 * {@link PlanetView} representations for rendering.
 * <p>
 * Provides methods to access the planets, their views, and to add new planets with automatically
 * generated views.
 */
public class PlanetContainer {

	private List<Planet> planets;
	private List<PlanetView> planetViews;

	/**
	 * Constructs a container with a given list of planets.
	 * Initializes a {@link PlanetView} for each planet.
	 *
	 * @param planets the initial planets
	 */
	public PlanetContainer(List<Planet> planets) {
		this.planets = planets;
		planetViews = new ArrayList<>(planets.size());
		planetViewsInitializer();
	}

	/** Initializes PlanetView objects for all planets in the container. */
	private void planetViewsInitializer() {
		for (Planet p : planets) {
			planetViews.add(new PlanetView(p, colorer(p)));
		}
	}

	/**
	 * Adds a planet to the container and creates its corresponding view.
	 *
	 * @param p the planet to add
	 */
	public void add(Planet p) {
		planets.add(p);
		planetViews.add(new PlanetView(p, colorer(p)));
	}

	/** Returns the list of planets in this container. */
	public List<Planet> getPlanets() {
		return planets;
	}

	/** Returns the list of planet views corresponding to the planets. */
	public List<PlanetView> getPlanetViews() {
		return planetViews;
	}

	/** Determines the display color for a planet based on its name. */
	private static Color colorer(Planet p) {
		return switch (p.getName()) {
			case "Earth" -> Color.AQUAMARINE;
			case "Sun" -> Color.YELLOW;
			case "Mercury" -> Color.DARKGREY;
			case "Moon" -> Color.GREY;
			case "Mars" -> Color.RED;
			case "Saturn" -> Color.LIGHTYELLOW;
			case "Jupiter" -> Color.ORANGE;
			case "Neptune" -> Color.DEEPSKYBLUE;
			case "Venus" -> Color.LIGHTGOLDENRODYELLOW;
			default -> Color.GHOSTWHITE;
		};
	}
}
