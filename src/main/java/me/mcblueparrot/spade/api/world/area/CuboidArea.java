package me.mcblueparrot.spade.api.world.area;

import java.util.ArrayList;
import java.util.List;

import me.mcblueparrot.spade.api.world.Location;
import me.mcblueparrot.spade.api.world.World;

/**
 * Represents a cuboid area made from two points.
 */
public class CuboidArea implements Area {

	private Location a;
	private Location b;

	/**
	 * Creates a cuboid area.
	 * @param world the world
	 * @param a the first location
	 * @param b the second location
	 */
	public CuboidArea(Location a, Location b) {
		if(!a.getWorld().equals(b.getWorld())) {
			throw new IllegalArgumentException("Both locations are in different worlds");
		}
		this.a = new Location(a);
		this.b = new Location(b);
	}

	/**
	 * Creates a copy of a cuboid area.
	 * @param area the cuboid area
	 */
	public CuboidArea(CuboidArea area) {
		this(area.a, area.b);
	}

	@Override
	public List<Location> getLocations(World world) {
		List<Location> locations = new ArrayList<Location>();
		int x1 = (int) Math.floor(Math.min(a.getX(), b.getX()));
		int x2 = (int) Math.floor(Math.max(a.getX(), b.getX()));
		int y1 = (int) Math.floor(Math.min(a.getY(), b.getY()));
		int y2 = (int) Math.floor(Math.max(a.getY(), b.getY()));
		int z1 = (int) Math.floor(Math.min(a.getZ(), b.getZ()));
		int z2 = (int) Math.floor(Math.max(a.getZ(), b.getZ()));
		for(int x = x1; x <= x2; x++) {
			for(int z = z1; z <= z2; z++) {
				for(int y = y1; y <= y2; y++) {
					locations.add(new Location(world, x, y, z));
				}
			}
		}
		return locations;
	}

	@Override
	public boolean contains(Location location) {
		double x1 = Math.min(a.getX(), b.getX());
		double x2 = Math.max(a.getX(), b.getX());
		double y1 = Math.min(a.getY(), b.getY());
		double y2 = Math.max(a.getY(), b.getY());
		double z1 = Math.min(a.getZ(), b.getZ());
		double z2 = Math.max(a.getZ(), b.getZ());
		double x = location.getX();
		double y = location.getX();
		double z = location.getX();
		return x >= x1 && x <= x2 && y >= y1 && y <= y2 && z >= z1 && z <= z2;
	}

	@Override
	public World getWorld() {
		return a.getWorld();
	}

	@Override
	public Area clone() {
		return new CuboidArea(this);
	}

}
