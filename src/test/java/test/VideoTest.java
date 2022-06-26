package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import model.Video;

public class VideoTest {

	static Video video;

	@BeforeClass
	public static void before() {
		video = new Video("Prueba", "direccionURLPrueba");
	}

	@Test
	public void testGet() {
		assertEquals("test getTitulo", "Prueba", video.getTitulo());
		assertEquals("test getUrl", "direccionURLPrueba", video.getUrl());
	}

	@Test
	public void testSet() {

		Video videoTest = new Video(video.getTitulo(), video.getUrl());

		video.setTitulo("Prueba 2");
		video.setUrl("direccionURLPrueba2");
		
		assertEquals("test getTitulo", "Prueba 2", video.getTitulo());
		assertEquals("test getUrl", "direccionURLPrueba2", video.getUrl());

		assertNotEquals("test setTitulo", videoTest.getTitulo(), video.getTitulo());
		assertNotEquals("test setUrl", videoTest.getUrl(), video.getUrl());
	}
}




