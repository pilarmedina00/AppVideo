package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.LinkedList;

import org.junit.BeforeClass;
import org.junit.Test;

import model.ListaVideos;
import model.Video;

public class ListaVideosTest {

	static ListaVideos playlist;

	@BeforeClass
	public static void before() {
		playlist = new ListaVideos("Playlist 1", new LinkedList<Video>());
	}

	@Test
	public void testGet() {
		assertEquals("test getNombreLista", "Playlist 1", playlist.getNombreLista());
		assertEquals("test getVideos", new LinkedList<Video>(), playlist.getVideos());
	}

	@Test
	public void testSet() {

		ListaVideos listaTest = new ListaVideos(playlist.getNombreLista(), playlist.getVideos());

		playlist.setNombreLista("Playlist 1 cambiada");
		LinkedList<Video> newPlaylist = new LinkedList<>();
		newPlaylist.add(new Video());
		playlist.setVideos(newPlaylist);

		assertEquals("test getNombreLista", "Playlist 1 cambiada", playlist.getNombreLista());
		assertEquals("test getVideos", newPlaylist, playlist.getVideos());
		
		assertNotEquals("test setNombre", listaTest.getNombreLista(), playlist.getNombreLista());
		assertNotEquals("test setCanciones", listaTest.getVideos(), playlist.getVideos());
	}
}
