package com.pchudzik.blog.examples.immutabledto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.beans.ConstructorProperties;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PointVanillaJava {
	private final int x;
	private final int y;

	@ConstructorProperties({"x", "y"})
	public PointVanillaJava(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
