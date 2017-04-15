package com.pchudzik.blog.examples.immutabledto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PointLombok {
	private final int x;
	private final int y;
}
