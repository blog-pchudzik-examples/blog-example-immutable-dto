package com.pchudzik.blog.examples.immutabledto

import com.fasterxml.jackson.databind.ObjectMapper
import org.skyscreamer.jsonassert.JSONAssert
import org.skyscreamer.jsonassert.JSONCompareMode
import spock.lang.Specification
import spock.lang.Unroll

class PointTest extends Specification {
	def objectMapper = new ObjectMapper()

	@Unroll
	def "should serialize point #point.class.simpleName to json"() {
		given:
		final stringWriter = new StringWriter()

		when:
		objectMapper.writer().writeValue(stringWriter, point)

		then:
		JSONAssert.assertEquals(
				"""{"x": 10, "y": 20}""",
				stringWriter.toString(), JSONCompareMode.STRICT)

		where:
		point << [
				new PointVanillaJava(10, 20),
				new PointLombok(10, 20)
		]
	}

	@Unroll
	def "should deserialize point #pointClass.simpleName from json"() {
		when:
		final point = objectMapper.readerFor(pointClass).readValue("""{"y":20, "x": 10}""")

		then:
		point.x == 10
		point.y == 20

		where:
		pointClass << [
				PointLombok.class,
				PointVanillaJava.class
		]
	}
}
